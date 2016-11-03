package contracts;

import java.sql.SQLException;

public interface DbContext {

    <E> boolean persist(E entity) throws IllegalAccessException, SQLException;

    <E> Iterable<E> find(Class<E> table)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    <E> Iterable<E> find(Class<E> table, String where)
            throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException;

    <E> E findFirst(Class<E> table)
            throws SQLException, InstantiationException, IllegalAccessException;

    <E> E findFirst(Class<E> table, String where)
            throws SQLException, InstantiationException, IllegalAccessException;
}
