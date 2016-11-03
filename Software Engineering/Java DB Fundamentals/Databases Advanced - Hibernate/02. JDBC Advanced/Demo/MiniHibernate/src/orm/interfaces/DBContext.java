package orm.interfaces;

import java.sql.SQLException;

/**
 * Created by teodo on 20/10/2016.
 */
public interface DBContext {

  	<E> boolean persist(E entity) throws SQLException, IllegalAccessException;

	<E> Iterable<E> find(Class<E> table);

	<E> Iterable<E> find(Class<E> table, String where);

	<E> E findFirst(Class<E> table);

	<E> E findFirst(Class<E> table, String where);
}
