package problem9IncreaseAgeStoredProcedure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer id = Integer.parseInt(reader.readLine());

//        String query =
//                "DELIMITER $$\n" +
//                "CREATE PROCEDURE usp_get_older(minion_id int)\n" +
//                "BEGIN\n" +
//                "\tUPDATE minions\n" +
//                "\tSET age = age + 1\n" +
//                "\tWHERE id = minion_id;\n" +
//                "END $$\n" +
//                "DELIMITER ;";

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = String.format("CALL usp_get_older(%d);", id);
            statement.execute(query);
            query = String.format(
                    "SELECT m.name, m.age FROM minions AS m\n" +
                    "WHERE m.id = %d;", id);
            ResultSet resultset = statement.executeQuery(query);
            if (resultset.next()) {
                System.out.println(String.format("%s %s", resultset.getString("name"), resultset.getString("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
