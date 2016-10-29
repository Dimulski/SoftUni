package problem3GetMinionNames;

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
        Integer target_villain_id = Integer.parseInt(reader.readLine());

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String query = String.format(
                    "SELECT v.name AS villain_name, m.name, m.age FROM minions AS m\n" +
                    "INNER JOIN villains_minions AS vm\n" +
                    "ON m.id = vm.minion_id\n" +
                    "INNER JOIN villains AS v\n" +
                    "ON vm.villain_id = v.id\n" +
                    "WHERE vm.villain_id = %s", target_villain_id);

            ResultSet resultSet = statement.executeQuery(query);

            String villain_name = null;
            int counter = 1;
            StringBuilder result = new StringBuilder();

            while (resultSet.next()) {
                if (villain_name == null) {
                    villain_name = resultSet.getString("villain_name");
                    result.append(String.format("Villain: %s%s", villain_name, System.lineSeparator()));
                }
                String minion_name = resultSet.getString("name");
                Integer minion_age = resultSet.getInt("age");
                result.append(String.format("%s. %s %d%s", counter++, minion_name, minion_age, System.lineSeparator()));
            }
            if (result.toString().equals("")) {
                returnProperResult(target_villain_id, statement);
            } else {
                System.out.println(result.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void returnProperResult(Integer target_villain_id, Statement statement) throws SQLException {
        String query = String.format("SELECT v.name FROM villains AS v\n" +
                                     "WHERE v.id = %s", target_villain_id);
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            System.out.println(String.format("Villain: %s\n" +
                                             "<no minions>", resultSet.getString("name")));
        } else {
            System.out.println(String.format("No villain with ID %d exists in the database.", target_villain_id));
        }
    }
}
