package com.company;

import java.sql.*;

public class GetVillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) {

        String selectVillainsNames = "SELECT v.name, COUNT(mv.minion_id) AS minions_count FROM villains AS v " +
                "JOIN minions_villains AS mv ON v.villains_id = mv.villains_id " +
                "GROUP BY mv.villains_id " +
                "HAVING minions_count > 3 " +
                "ORDER BY minions_count DESC;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        ) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectVillainsNames);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int num = resultSet.getInt("minions_count");
                System.out.printf("%s %d", name, num);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
