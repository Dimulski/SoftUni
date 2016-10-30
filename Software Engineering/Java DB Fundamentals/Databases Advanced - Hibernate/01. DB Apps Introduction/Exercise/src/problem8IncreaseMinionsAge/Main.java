package problem8IncreaseMinionsAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String formattedIds = reader.readLine().trim().replaceAll("\\s+", ", ");

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                Statement innerStatement = connection.createStatement();
        ) {
            String query = String.format(
                    "SELECT m.id, m.name FROM minions AS m\n" +
                    "WHERE m.id IN (%s);", formattedIds);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                List<String> names = Arrays.asList(resultSet.getString("name").trim().split("\\s+"));
                for (int i = 0; i < names.size(); i++) {
                    names.set(i, Character.toUpperCase(names.get(i).charAt(0)) + names.get(i).substring(1));
                }
                String titleCasedName = String.join(" ", names);
                Integer id = resultSet.getInt("id");

                query = String.format(
                        "UPDATE minions AS m\n" +
                        "SET m.age = m.age + 1,\n" +
                        "m.name = '%s'\n" +
                        "WHERE m.id = %d;", titleCasedName, id);
                innerStatement.execute(query);
            }

            query = "SELECT m.name, m.age FROM minions AS m;";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(String.format("%s %s", resultSet.getString("name"), resultSet.getString("age")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
