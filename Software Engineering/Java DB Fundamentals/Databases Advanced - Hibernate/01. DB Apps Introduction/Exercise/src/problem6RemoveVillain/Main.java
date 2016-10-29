package problem6RemoveVillain;

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
        Integer villainId = Integer.parseInt(reader.readLine());

        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = String.format(
                    "SELECT * FROM villains AS v\n" +
                    "WHERE v.id = %d;", villainId);
            ResultSet resultSet = statement.executeQuery(query);
            String villainName = resultSet.next() ? resultSet.getString("name") : null;

            if (villainName == null) {
                System.out.println("No such villain was found");
            } else {
                query = String.format(
                        "SELECT COUNT(*) AS minion_count FROM villains_minions AS vm\n" +
                        "WHERE vm.villain_id = %d;", villainId);
                resultSet = statement.executeQuery(query);
                Integer minionCount = resultSet.next() ? resultSet.getInt("minion_count") : 0;

                query = String.format(
                        "DELETE FROM villains_minions\n" +
                        "WHERE villain_id = %d;", villainId);
                statement.execute(query);

                query = String.format(
                        "DELETE FROM villains\n" +
                        "WHERE id = %d;", villainId);
                statement.execute(query);

                System.out.println(String.format("%s was deleted%s%d minion%s released", villainName,
                        System.lineSeparator(), minionCount, minionCount == 1 ? "" : "s"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
