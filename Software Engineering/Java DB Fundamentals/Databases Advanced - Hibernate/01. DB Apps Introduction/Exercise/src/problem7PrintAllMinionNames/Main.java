package problem7PrintAllMinionNames;

import java.sql.*;
import java.util.LinkedList;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        LinkedList<String> minions = new LinkedList<>();
        LinkedList<String> minionsOrdered = new LinkedList<>();
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
        ) {
            String query = "SELECT name FROM minions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                minions.add(resultSet.getString("name"));
            }
            while (!minions.isEmpty()) {
                String first = minions.poll();
                String last = minions.pollLast();
                minionsOrdered.add(first);
                minionsOrdered.add(last);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (minionsOrdered.peekLast() == null) {
            minionsOrdered.pollLast();
        }

        minionsOrdered.forEach(System.out::println);
    }
}
