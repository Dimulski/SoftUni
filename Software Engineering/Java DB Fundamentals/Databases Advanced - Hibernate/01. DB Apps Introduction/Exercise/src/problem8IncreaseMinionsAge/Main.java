package problem8IncreaseMinionsAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] minionIds = reader.readLine().split(" ");
        StringBuilder result = new StringBuilder();

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query =String.format(
                    "SELECT * FROM minions AS m" +
                            "WHERE id IN (%s);", Arrays.toString(minionIds).replaceAll("[\\[\\]]",""));
            ResultSet resultSet = statement.executeQuery(query);

            String update = String.format(
                    "UPDATE minions " +
                    "SET age = age + 1," +
                    "name = CONCAT(UPPER(LEFT(name, 1))," +
                    "SUBSTRING(name, 2)) " +
                    "WHERE minion_id IN (%s);",
                    Arrays.toString(arrayID).replaceAll("[\\[\\]]",""));
            statement.execute(update);
            String selectAllMinions = "SELECT name,age FROM minions";
            ResultSet resultSet = statement.executeQuery(selectAllMinions);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                result.append(name).append(" ").append(age);
                result.append(System.lineSeparator());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
