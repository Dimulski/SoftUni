package problem1InitialSetup;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        String queryLine = "DROP DATABASE IF EXISTS `minions_db`;";
        StringBuilder queryBuilder;

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(queryLine);

            queryLine = "CREATE DATABASE `minions_db`;";
            statement.execute(queryLine);
            queryLine = "USE `minions_db`;";
            statement.execute(queryLine);

            queryBuilder = new StringBuilder(
                            "CREATE TABLE `countries` (\n")
                    .append("  id int NOT NULL AUTO_INCREMENT,\n")
                    .append("  name varchar(50),\n")
                    .append("  PRIMARY KEY (id)\n")
                    .append(") AUTO_INCREMENT = 1;");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "CREATE TABLE `towns` (\n")
                    .append("  id int NOT NULL AUTO_INCREMENT,\n")
                    .append("  name varchar(50),\n")
                    .append("  country_id int,\n")
                    .append("  PRIMARY KEY (id),\n")
                    .append("  CONSTRAINT fk_towns_countries FOREIGN KEY (country_id) REFERENCES `countries` (id)\n")
                    .append(") AUTO_INCREMENT = 1;");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "CREATE TABLE `minions` (\n")
                    .append("  id int NOT NULL AUTO_INCREMENT,\n")
                    .append("  name varchar(50),\n")
                    .append("  age int,\n")
                    .append("  town_id int,\n")
                    .append("  PRIMARY KEY (id),\n")
                    .append("  CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES `towns` (id) \n")
                    .append(") AUTO_INCREMENT = 1;");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "CREATE TABLE `villains` (\n")
                    .append("  id int NOT NULL AUTO_INCREMENT,\n")
                    .append("  name varchar(50),\n")
                    .append("  evilness_factor enum('good', 'bad', 'evil', 'super evil'),\n")
                    .append("  PRIMARY KEY (id)\n")
                    .append(") AUTO_INCREMENT = 1;");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "CREATE TABLE `villains_minions` (\n")
                    .append("  villain_id int NOT NULL,\n")
                    .append("  minion_id int NOT NULL,\n")
                    .append("  PRIMARY KEY (villain_id, minion_id),\n")
                    .append("  CONSTRAINT fk_villains_minions_villains FOREIGN KEY (villain_id) REFERENCES `villains` (id),\n")
                    .append("  CONSTRAINT fk_villains_minions_minions FOREIGN KEY (minion_id) REFERENCES `minions` (id)\n")
                    .append(");");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "INSERT INTO `countries` (name) VALUES\n")
                    .append("\t('Bulgaria'),\n")
                    .append("\t('United Kingdom'),\n")
                    .append("\t('United States'),\n")
                    .append("\t('Japan'),\n")
                    .append("\t('Sweden');");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "INSERT INTO `towns` (name, country_id) VALUES\n")
                    .append("\t('Plovdiv', 1),\n")
                    .append("\t('Edinburgh', 2),\n")
                    .append("\t('Massachusetts', 3),\n")
                    .append("\t('Kyoto', 4),\n")
                    .append("\t('Uppsala', 5);");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "INSERT INTO `minions` (name, age, town_id) VALUES\n")
                    .append("\t('George', 19, 1),\n")
                    .append("\t('Ethan', 26, 2),\n")
                    .append("\t('Lora', 20, 3),\n")
                    .append("\t('Julian', 24, 4),\n")
                    .append("\t('Minna', 33, 5);");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "INSERT INTO `villains` (name, evilness_factor) VALUES\n")
                    .append("\t('HAL', 'evil'),\n")
                    .append("\t('Amon', 'super evil'),\n")
                    .append("\t('Hannibal', 'super evil'),\n")
                    .append("\t('Raoul', 'good'),\n")
                    .append("\t('Pete', 'bad');");
            statement.execute(queryBuilder.toString());

            queryBuilder = new StringBuilder(
                            "INSERT INTO `villains_minions` (villain_id, minion_id) VALUES\n")
                    .append("\t(1, 1),\n")
                    .append("\t(3, 3),\n")
                    .append("\t(4, 1),\n")
                    .append("\t(4, 2),\n")
                    .append("\t(4, 3),\n")
                    .append("\t(4, 4),\n")
                    .append("\t(4, 5),\n")
                    .append("\t(5, 1),\n")
                    .append("\t(5, 2),\n")
                    .append("\t(5, 3),\n")
                    .append("\t(5, 4);");
            statement.execute(queryBuilder.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
