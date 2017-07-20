package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialSetup {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME  = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) {

        String createQuery = "CREATE DATABASE minions_db;";
        String useQuery = "USE minions_db;";

        String createMinionsTableQuery = "CREATE TABLE minions( " +
                "minion_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "age INT, " +
                "town_id INT, " +
                "FOREIGN KEY (town_id) REFERENCES towns(town_id));";

        String createVillainsTable = "CREATE TABLE villains( " +
                "villains_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "evilness_factor VARCHAR(50));";

        String createTownsTableQuery = "CREATE TABLE towns( " +
                "town_id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "country VARCHAR(50));";

        String mapTable = "CREATE TABLE minions_villains( " +
                "minion_id INT, " +
                "villains_id INT, " +
                "PRIMARY KEY (minion_id, villains_id), " +
                "FOREIGN KEY (minion_id) REFERENCES minions (minion_id), " +
                "FOREIGN KEY (villains_id) REFERENCES villains (villains_id));";

        String insertVillains = "INSERT INTO villains(name, evilness_factor) " +
                "VALUES ('Rob', 'good'), ('Bob', 'bad'), ('Stiv', 'evil'), ('John', 'super_evil'), ('James', 'good')";

        String insertMinions = "INSERT INTO minions(name, age, town_id) " +
                "VALUES ('Joro', 15, 1), ('Vlado', 29, 3), ('Marin', 33, 5), ('Petar', 28, 4), ('Ivan', 30, 2)";

        String insertTowns = "INSERT INTO towns(name, country) " +
                "VALUES ('Sofia', 'Bulgaria'), ('Plovdiv', 'Bulgaria'), ('Amsterdam', 'Holland'), " +
                "('Varna', 'Bulgaria'), ('LA', 'USA'), ('Berlin', 'Germany'), ('Paris', 'France'), ('Munich', 'Germany')";

        String insertMaps = "INSERT INTO minions_villains " +
                "VALUES (1, 5), (3, 2), (2, 3), (4, 4), (5, 1), (1, 1), (2, 1), (3, 3), (1, 3), (5, 3), (5, 2), (4, 3)";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                ){

            statement.executeUpdate(createQuery);
            statement.executeQuery(useQuery);
            statement.executeUpdate(createTownsTableQuery);
            statement.executeUpdate(createMinionsTableQuery);
            statement.executeUpdate(createVillainsTable);
            statement.executeUpdate(mapTable);

            statement.executeUpdate(insertVillains);
            statement.executeUpdate(insertTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertMaps);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}