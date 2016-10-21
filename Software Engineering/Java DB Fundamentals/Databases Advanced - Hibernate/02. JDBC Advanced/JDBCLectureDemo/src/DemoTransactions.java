import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by teodo on 19/10/2016.
 */
public class DemoTransactions {
    public static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false";

    public static final String sqlInsert = "INSERT INTO Students(id, name)" +
            "VALUES(3, 'Ivan')";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","1234");

        try(Connection connection = DriverManager.getConnection(URL, properties);
            Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.execute(sqlInsert);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
