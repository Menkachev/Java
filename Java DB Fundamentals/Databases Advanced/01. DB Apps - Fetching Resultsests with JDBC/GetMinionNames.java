package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetMinionNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer villainId = Integer.parseInt(reader.readLine());
        List<String> minions = new ArrayList<>();

        String sql = "SELECT v.name, m.name, m.age FROM minions AS m " +
                "JOIN minions_villains AS mv ON m.minion_id = mv.minion_id " +
                "JOIN villains AS v ON mv.villains_id = v.villains_id " +
                "WHERE mv.villains_id = ?;";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, villainId);
            ResultSet resultSet = statement.executeQuery();

            String villaimName = "";
            Integer counter = 0;

            while (resultSet.next()){
                villaimName = resultSet.getString("v.name");
                String minionName = resultSet.getString("m.name");
                Integer minionAge = resultSet.getInt("m.age");
                counter++;

                minions.add(String.format("%d. %s %d", counter, minionName,minionAge));
            }

            if (villaimName.equals("")){
                System.out.printf("No villain with ID %d exists in the database.", villainId);
            } else {
                System.out.printf("Villain: %s\n", villaimName);
                minions.forEach(System.out::println);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
