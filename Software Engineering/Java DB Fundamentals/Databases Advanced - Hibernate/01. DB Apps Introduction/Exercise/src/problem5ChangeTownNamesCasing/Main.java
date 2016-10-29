package problem5ChangeTownNamesCasing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String country_name = reader.readLine();

        String query = null;
        Integer counter = 0;
        List<String> newTownNames = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            query = String.format(
                    "SELECT t.id AS town_id, t.name AS town_name, t.country_id,\n" +
                    "c.id AS country_id, c.name AS country_name FROM towns AS t\n" +
                    "INNER JOIN countries AS c\n" +
                    "ON t.country_id = c.id\n" +
                    "WHERE c.name = '%s';", country_name);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String town_name = resultSet.getString("town_name");
                query = String.format(
                        "UPDATE towns AS t\n" +
                        "SET t.name = '%s'\n" +
                        "WHERE t.name = '%s';\n", town_name.toUpperCase(), town_name);
                counter++;
                newTownNames.add(town_name.toUpperCase());
            }

            if (counter > 0) {
                System.out.println(String.format("%s town names were affected.", counter));
                System.out.println(newTownNames);
            } else {
                System.out.println("No town names were affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
