package problem2GetVillainsNames;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String query = "SELECT v.name, COUNT(vm.minion_id) AS minion_count FROM villains_minions AS vm\n" +
                           "INNER JOIN villains AS v\n" +
                           "ON vm.villain_id = v.id\n" +
                           "GROUP BY vm.villain_id\n" +
                           "HAVING minion_count >= 3\n" +
                           "ORDER BY minion_count DESC";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int minion_count = resultSet.getInt("minion_count");
                System.out.println(name + " " + minion_count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
