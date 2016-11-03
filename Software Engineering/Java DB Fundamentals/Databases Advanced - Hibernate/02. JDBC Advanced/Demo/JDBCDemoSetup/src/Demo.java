import java.sql.*;

/**
 * Created by teodo on 20/10/2016.
 */
public class Demo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "1234";

        String sqlCreate = "CREATE TABLE students( " +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) " +
                ")";


        String sqlInsert = "INSERT INTO students(id, name) " +
                "VALUES(1, 'Teo')";

        String sqlSelect = "SELECT id, name FROM students";

        String sqlSelectWhere = "SELECT id, name FROM students WHERE id = ?";

        String sqlProcedure = "CALL usp_update_student(?,?)";

        try(Connection connection = DriverManager.getConnection(url, user, password);
            //Statement statement = connection.createStatement()
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectWhere);
            CallableStatement callableStatement = connection.prepareCall(sqlProcedure);
        ) {
            //boolean result = statement.execute(sqlCreate);
            //int affectedRows = statement.executeUpdate(sqlInsert);
            //System.out.println(affectedRows);
//            ResultSet resultSet = statement.executeQuery(sqlSelect);

//            preparedStatement.setInt(1,3);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                System.out.println(String.format("Student id: %d, Student name: %s", id, name));

            callableStatement.setInt("id", 1);
            callableStatement.setString("name","John");
            callableStatement.execute();
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
