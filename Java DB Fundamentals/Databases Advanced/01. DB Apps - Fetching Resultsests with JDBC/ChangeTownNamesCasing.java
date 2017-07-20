package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTownNamesCasing {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String countryName = reader.readLine();
        List<String> townNames = new ArrayList<>();

        String selectTownCount = "SELECT COUNT(t.name) AS countTowns FROM towns AS t " +
                "WHERE t.country = ? " +
                "GROUP BY t.country;";

        String selectTownNames = "SELECT t.name FROM towns AS t " +
                "WHERE t.country = ?;";


        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ){
            PreparedStatement countStatement = connection.prepareStatement(selectTownCount);
            countStatement.setString(1, countryName);
            ResultSet countResult = countStatement.executeQuery();

            PreparedStatement statement = connection.prepareStatement(selectTownNames);
            statement.setString(1, countryName);
            ResultSet resultSet = statement.executeQuery();

            if (countResult.next()){
                Integer count = countResult.getInt("countTowns");
                System.out.printf("%d town names were affected.\n", count);

                if (resultSet.next()){
                    townNames.add(resultSet.getString("t.name").toUpperCase());
                    System.out.printf("[%s]", String.join(", ", townNames));
                }
            } else {
                System.out.println("No town names were affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}