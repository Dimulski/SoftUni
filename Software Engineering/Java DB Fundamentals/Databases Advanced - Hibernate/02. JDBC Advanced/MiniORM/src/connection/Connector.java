package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    private static Connection connection = null;

    private static final String CONNECTION_FORMAT = "jdbc:%s://%s:%s/%s?useSSL=false";

    public static void initConnection(
            String driver, String username, String password, String host, String port, String dbName)
            throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", username);
        connectionProps.put("password", password);
        connection = DriverManager.getConnection(
                String.format(CONNECTION_FORMAT, driver, host, port, dbName), connectionProps);
    }

    public static Connection getConnection() {
        return connection;
    }
}
