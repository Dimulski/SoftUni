package orm;

import orm.interfaces.DBContext;
import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.lang.reflect.Field;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class EntityManager implements DBContext {

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <E> boolean persist(E entity) throws SQLException, IllegalAccessException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);

        this.doCreate(entity, primary);

        Object value = primary.get(entity);
        if (value == null || (Long)value <= 0) {
            return this.doInsert(entity, primary);
        }

        return this.doUpdate(entity, primary);
    }

    private <E> boolean doUpdate(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String sqlUpdate = "UPDATE " + tableName + " SET ";
        String where = "WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (field.getName().equals(primary.getName())) {
                String primaryColumnName = this.getFieldName(primary);
                Long primaryColumnValue = (Long) primary.get(entity);
                where += "`" + primaryColumnName + "`" + " = '" + primaryColumnValue + "'";
                continue;
            }

            Object value = field.get(entity);
            if (value instanceof Date) {
                sqlUpdate += "`" +this.getFieldName(field) + "` = "
                        + "'" + new SimpleDateFormat("yyyyMMdd").format(value) + "'";
            } else {
                sqlUpdate += "`" + this.getFieldName(field) + "` = "
                        + "'" + value + "'";
            }

            if (i < fields.length - 1) {
                sqlUpdate += ", ";
            }
        }

        sqlUpdate += where;

        return this.connection.prepareStatement(sqlUpdate).execute();
    }

    private <E> boolean doInsert(E entity, Field primary) throws IllegalAccessException, SQLException {
        String tableName = this.getTableName(entity.getClass());
        String sqlInsert = "INSERT INTO " + tableName + "(";

        String columns = "";
        String values = "";
        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!field.getName().equals(primary.getName())) {
                columns += "`" + this.getFieldName(field) + "`";

                Object value = field.get(entity);
                if (value instanceof java.util.Date) {
                    values += "'" + new SimpleDateFormat("yyyy-MM-dd").format(value) + "'";
                } else {
                    values += "'" + value + "'";
                }

                if (i < fields.length - 1) {
                    columns += ", ";
                    values += ", ";
                }
            }
        }

        sqlInsert += columns + ") "
                + "VALUES(" + values + ")";

        return this.connection.prepareStatement(sqlInsert).execute();
    }

    @Override
    public <E> Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table) {
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) {
        return null;
    }

    private <E> String getTableName(Class<E> entity) {
        String tableName = "";

        if (entity.isAnnotationPresent(Entity.class)) {
            Entity entityAnnoitation = entity.getAnnotation(Entity.class);
            tableName = entityAnnoitation.name();
        }

        if (tableName.equals("")) {
            tableName = entity.getSimpleName();
        }

        return tableName;
    }

    private String getFieldName(Field field) {
        String fieldName = "";

        if (field.isAnnotationPresent(Column.class)) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            fieldName = columnAnnotation.name();
        }

        if (fieldName.equals("")) {
            fieldName = field.getName();
        }

        return fieldName;
    }

    private Field getId(Class c) {
        return Arrays.stream(c.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new IllegalAccessError(""));
    }

    private <E> boolean doCreate(E entity, Field primary) throws SQLException {
        String tableName = this.getTableName(entity.getClass());
        String sqlCreate = "CREATE TABLE IF NOT EXISTS " + tableName + "( ";

        String columns = "";

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (field.getName().equals(primary.getName())) {
                columns += "`" + this.getFieldName(field) + "` "
                        + " BIGINT " +
                        " PRIMARY KEY AUTO_INCREMENT ";
            } else {
                columns += "`" + this.getFieldName(field) + "` "
                        + this.getDatabaseType(field);
            }

            if (i < fields.length - 1) {
                columns += ", ";
            }
        }

        sqlCreate += columns + ")";

        return connection.prepareStatement(sqlCreate).execute();
    }

    private String getDatabaseType(Field field) {
        switch (field.getType().getSimpleName().toLowerCase()) {
            case "int":
                return "INT";
            case "string":
                return "VARCHAR(50)";
            case "long":
                return "LONG";
            case "date":
                return "DATE";
        }

        return null;
    }
}
