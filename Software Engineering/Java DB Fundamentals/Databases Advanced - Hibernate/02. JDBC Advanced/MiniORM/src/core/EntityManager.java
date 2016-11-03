package core;

import contracts.DbContext;
import persistence.Column;
import persistence.Entity;
import persistence.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EntityManager implements DbContext {

    private Connection connection;
    private Set<Object> persistedEntities;

    public EntityManager(Connection connection) {
        this.connection = connection;
        this.persistedEntities = new HashSet<>();
    }

    @Override
    public <E> boolean persist(E entity) throws IllegalAccessException, SQLException {

        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object value = primary.get(entity);

        this.doCreate(entity, primary);

        if (value == null || (Long)value <= 0) {
            return this.doInsert(entity, primary);
        }

        return this.doUpdate(entity, primary);
    }

    @Override
    public <E> Iterable<E> find(Class<E> table)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        // TODO: make the implementation
        return null;
    }

    @Override
    public <E> Iterable<E> find(Class<E> table, String where)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        // TODO: make the implementation
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table) throws SQLException, InstantiationException, IllegalAccessException {

        // TODO: make the implementation
        return null;
    }

    @Override
    public <E> E findFirst(Class<E> table, String where)
            throws SQLException, InstantiationException, IllegalAccessException {

        Statement statement = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " WHERE 1 "
                + (where != null ? "AND " + where : "") + " LIMIT 1";
        ResultSet resultSet = statement.executeQuery(query);
        E entity = table.newInstance();
        resultSet.next();
        this.fillEntity(table, resultSet, entity);

        return entity;
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
                .orElseThrow(() -> new IllegalAccessError());
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
        }

        return null;
    }

    private <E> boolean doInsert(E entity, Field primary) throws SQLException, IllegalAccessException {

        String query = "INSERT INTO " + this.getTableName(entity.getClass()) + " ";
        return connection.prepareStatement(query).execute();
    }

    private <E> boolean doUpdate(E entity, Field primary) throws SQLException, IllegalAccessError {

        String query = "UPDATE " + this.getTableName(entity.getClass()) + " SET ";
        String where = "WHERE 1=1 ";
        return connection.prepareStatement(query + where).execute();
    }
}
