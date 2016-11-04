package core;

import contracts.DbContext;
import persistence.Column;
import persistence.Entity;
import persistence.Id;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

public class EntityManager implements DbContext, AutoCloseable {

    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);

        this.doCreate(entity, primary);

        Object value = primary.get(entity);
        if (value == null || (Long)value <= 0) {
            return this.doInsert(entity, primary);
        }

        return this.doUpdate(entity, primary);
    }

    @Override
    public <E> Iterable<E> find(Class<E> table)
            throws SQLException, InstantiationException, IllegalAccessException {

        return this.find(table, "1");
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where)
            throws SQLException, InstantiationException, IllegalAccessException {

        String select = "SELECT * FROM " + this.getTableName(table) + " WHERE " + where;

        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        List<E> entities = new ArrayList<E>();
        while (resultSet.next()) {
            E entity = this.fillEntity(table, resultSet);
            entities.add(entity);
        }
        resultSet.close();
        statement.close();
        return Collections.unmodifiableCollection(entities);
    }

    @Override
    public <E> E findFirst(Class<E> table) throws SQLException, InstantiationException, IllegalAccessException {

        Iterator<E> e = this.find(table, "1 LIMIT 1").iterator();
        return e.next();
    }

    @Override
    public <E> E findFirst(Class<E> table, String where)
            throws SQLException, InstantiationException, IllegalAccessException {

        Iterator<E> e = this.find(table, where + " LIMIT 1").iterator();
        return e.next();
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }

    @Override
    public <E> void deleteObject(Class<E> table, long id) throws SQLException {
        String delete = "DELETE FROM " + this.getTableName(table) + " WHERE id = " + id;
        Statement statement = this.connection.createStatement();
        statement.execute(delete);
        statement.close();
    }

    private <E> String getTableName(Class<E> entity) {
        String tableName;
        if (entity.isAnnotationPresent(Entity.class)) {
            Entity entityAnnotation = entity.getAnnotation(Entity.class);
            tableName = entityAnnotation.name();
        } else {
            tableName = entity.getSimpleName();
        }
        return tableName;
    }

    private <E> E fillEntity(Class<E> table, ResultSet resultSet)
            throws InstantiationException, SQLException, IllegalAccessException {

        E entity = table.newInstance();
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Field[] fields = table.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            String databaseType = this.getDatabaseType(field, primary);
            field.set(entity, databaseType.equals("TINYINT") ?
                    (resultSet.getBoolean(fieldName))
                    : resultSet.getObject(fieldName));
        }
        return entity;
    }

    private String getFieldName(Field field) {
        String fieldName;
        if (field.isAnnotationPresent(Column.class)) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            fieldName = columnAnnotation.name();
        } else {
            fieldName = field.getName();
        }
        return fieldName;
    }

    private Field getId(Class c) {
        return Arrays.stream(c.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }

    private <E> boolean doCreate(E entity, Field primary) throws SQLException, IllegalAccessException {

        String tableName = this.getTableName(entity.getClass());
        String query = "CREATE TABLE IF NOT EXISTS " + tableName + "( ";

        String columns = "";

        Field[] fields = entity.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            columns += "`" + this.getFieldName(field) + "` " +
                    this.getDatabaseType(field, primary);

            if (i < fields.length - 1) {
                columns += ", ";
            }
        }

        query += columns + ")";

        return connection.prepareStatement(query).execute();
    }

    private <E> boolean doInsert(E entity, Field primary) throws SQLException, IllegalAccessException {
        String tableName = this.getTableName(entity.getClass());
        String query = "INSERT INTO " + tableName + "(";

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
                } else if(value instanceof Boolean) {
                    values += "'" + ((Boolean)value ? "1" : "0") + "'";
                } else {
                    values += "'" + value + "'";
                }

                if (i < fields.length - 1) {
                    columns += ", ";
                    values += ", ";
                }
            }
        }

        query += columns + ") " + "VALUES(" + values + ")";
        return this.connection.prepareStatement(query).execute();
    }

    private <E> boolean doUpdate(E entity, Field primary)
            throws SQLException, IllegalAccessError, IllegalAccessException {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(String.format("UPDATE %s", this.getTableName(entity.getClass())));

        queryBuilder.append(" SET ");
        Field[] fields = entity.getClass().getDeclaredFields();
        String where = " WHERE ";
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = this.getFieldName(field);
            Object value = field.get(entity);
            if (field.isAnnotationPresent(Id.class)) {
                where += fieldName + " = " + value;
                continue;
            }

            value = value instanceof Date ?
                    new SimpleDateFormat("yyyy-MM-dd").format(value) :
                    value;
            value = value instanceof Boolean ? ((Boolean) value ? 1 : 0) : value;

            queryBuilder.append("`").append(fieldName).append("`").append(" = ")
                    .append("'").append(value).append("'").append(", ");
        }
        queryBuilder.setLength(queryBuilder.length() - 2);
        queryBuilder.append(where);

        return this.connection.prepareStatement(queryBuilder.toString()).execute();
    }

    private String getDatabaseType(Field field, Field primary) {

        field.setAccessible(true);
        if (field.getName().equals(primary.getName())) {
            return "BIGINT PRIMARY KEY AUTO_INCREMENT";
        }

        switch (field.getType().getSimpleName().toLowerCase()) {
            case "int":
                return "INT";
            case "string":
                return "varchar(50)";
            case "long":
                return "LONG";
            case "date":
                return "DATE";
            case "boolean":
                return "TINYINT";
            default:
                throw new NotImplementedException();

        }
    }
}
