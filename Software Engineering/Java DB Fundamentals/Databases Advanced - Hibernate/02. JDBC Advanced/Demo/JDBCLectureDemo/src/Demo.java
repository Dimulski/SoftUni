import java.sql.*;
import java.util.Properties;

/**
 * Created by teodo on 19/10/2016.
 */
public class Demo {

    public static final String URL = "jdbc:mysql://localhost:3306/school?useSSL=false";
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password","1234");

        String sqlCreate = "CREATE TABLE IF NOT EXISTS Students(id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(50))";
        String sqlInsert = "INSERT INTO Students(id, name)" +
                "VALUES(2, 'John')";

        String sqlSelectWhere = "SELECT * FROM students " +
                "WHERE id = ? " +
                "AND name = ? ";

        String sqlSelect = "SELECT id, name FROM students";

        String sqlProcedure = "CALL usp_update_student(?,?)";
        try(Connection connection = DriverManager.getConnection(URL,properties);
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlProcedure);
            CallableStatement callableStatement = connection.prepareCall(sqlProcedure);
        ){
            //DDL
            // int affectedRows = statement.executeUpdate(sqlInsert);

            //DML
            //boolean affectedRows = statement.execute(sqlInsert);
            // System.out.println("Affected rows: " + affectedRows);

//            ResultSet resultSet = statement.executeQuery(sqlSelect);
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                System.out.println(String.format("Student id: %d, Student name; %s",id, name));
//            }

//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"John");
//            ResultSet resultSet =  preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                System.out.println(String.format("Student id: %d, Student name; %s",id, name));
//            }

            callableStatement.setInt(1, 2);
            callableStatement.setString("name","Teo");
            callableStatement.setString(2,"Teo");
            int affectedRows= callableStatement.executeUpdate();
//            System.out.println("Affected rows: " + affectedRows);
            preparedStatement.setInt(1,2);
            preparedStatement.setString(2,"Teo");
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
