package problem4AddMinion;

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
        String[] input = reader.readLine().split(" ");
        String minion_name = input[1];
        Integer age = Integer.parseInt(input[2]);
        String town_name = input[3];
        String villain_name = reader.readLine().split(" ")[1];

        Integer town_id;
        Integer villain_id;
        Integer minion_id;
        String defaultEvilnessFactor = "evil";

        StringBuilder resultText = new StringBuilder();
        String query;
        String secondaryQuery;

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            connection.setAutoCommit(false);
            query = String.format(
                    "SELECT * FROM towns AS t\n" +
                    "WHERE t.name = '%s';", town_name);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                town_id = resultSet.getInt("id");
            } else {
                secondaryQuery = String.format(
                        "INSERT INTO towns (name, country_id) VALUES\n" +
                        "\t('%s', NULL);", town_name);
                statement.execute(secondaryQuery);
                resultSet = statement.executeQuery(query);
                resultSet.next();
                town_id = resultSet.getInt("id");
                resultText.append(String.format("Town %s was added to the database.%s", town_name, System.lineSeparator()));
            }

            query = String.format(
                    "SELECT * FROM villains AS v\n" +
                    "WHERE v.name = '%s';", villain_name);
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                villain_id = resultSet.getInt("id");
            } else {
                secondaryQuery = String.format(
                        "INSERT INTO villains (name, evilness_factor) VALUES\n" +
                        "\t('%s', '%s');", villain_name, defaultEvilnessFactor);
                statement.execute(secondaryQuery);
                resultSet = statement.executeQuery(query);
                resultSet.next();
                villain_id = resultSet.getInt("id");
                resultText.append(String.format("Villain %s was added to the database.%s", villain_name, System.lineSeparator()));
            }

            query = String.format(
                    "INSERT INTO minions (name, age, town_id) VALUES\n" +
                    "\t('%s', %s, %s);", minion_name, age, town_id);
            statement.execute(query);

            query = String.format(
                    "SELECT * FROM minions AS m\n" +
                    "WHERE m.name = '%s';", minion_name);
            resultSet = statement.executeQuery(query);
            resultSet.next();
            minion_id = resultSet.getInt("id");

            query = String.format(
                    "INSERT INTO villains_minions (villain_id, minion_id) VALUES\n" +
                    "\t(%s, %s);", villain_id, minion_id);
            statement.execute(query);
            resultText.append(String.format("Successfully added %s to be minion of %s%s", minion_name, villain_name,
                    System.lineSeparator()));

            connection.commit();
            System.out.println(resultText.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
