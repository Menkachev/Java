package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class AddMinion {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME  = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] minionInfo = reader.readLine().split("\\s");
        String minionName = minionInfo[1];
        Integer minionAge = Integer.parseInt(minionInfo[2]);
        String townName = minionInfo[3];

        String[] villainInfo = reader.readLine().split("\\s");
        String villainName = villainInfo[1];

        String selectTownQuery = "SELECT * FROM towns WHERE name = ?";
        String selectVillainQuery = "SELECT * FROM villains WHERE name = ?";
        String selectMinionQuery = "SELECT * FROM minions WHERE name = ?";

        String insertTownQuery = "INSERT INTO towns(name) VALUES(?)";
        String insertVillainQuery = "INSERT INTO villains(name, evilness_factor) VALUES(?, 'evil')";

        String insertMinionsQuery = "INSERT INTO minions(name, age, town_id) VALUES(?, ?, ?)";
        String insertMapQuery = "INSERT INTO minions_villains(minion_id, villains_id) VALUES(?, ?)";

        try (
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                ){
            PreparedStatement townStatement = connection.prepareStatement(selectTownQuery);
            townStatement.setString(1, townName);
            ResultSet townResult = townStatement.executeQuery();

            if (!townResult.next()){
                PreparedStatement insertTownStatement = connection.prepareStatement(insertTownQuery);
                insertTownStatement.setString(1, townName);
                insertTownStatement.executeUpdate();
                System.out.printf("Town %s was added to the database.\n", townName);
                insertTownStatement.close();
            }

            int townId = 0;
            ResultSet townResultUpdated = townStatement.executeQuery();

            if (townResultUpdated.next()){
                 townId = townResultUpdated.getInt("town_id");
            }
            townStatement.close();

            PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillainQuery);
            selectVillainStatement.setString(1, villainName);
            ResultSet villainResult = selectVillainStatement.executeQuery();

            if (!villainResult.next()){
                PreparedStatement insertVillainStatement = connection.prepareStatement(insertVillainQuery);
                insertVillainStatement.setString(1, villainName);
                insertVillainStatement.executeUpdate();
                insertVillainStatement.close();
            }

            int villainId = 0;
            ResultSet villainResultUpdated = selectVillainStatement.executeQuery();
            if (villainResultUpdated.next()){
              villainId = villainResultUpdated.getInt("villains_id");
                System.out.printf("Villain %s was added to the database.\n", villainName);
            }
            selectVillainStatement.close();

            PreparedStatement insertMinionsStatement = connection.prepareStatement(insertMinionsQuery);
            insertMinionsStatement.setString(1, minionName);
            insertMinionsStatement.setInt(2, minionAge);
            insertMinionsStatement.setInt(3, townId);
            insertMinionsStatement.executeUpdate();
            insertMinionsStatement.close();

            PreparedStatement selectMinionStatement = connection.prepareStatement(selectMinionQuery);
            selectMinionStatement.setString(1, minionName);

            ResultSet minionResult = selectMinionStatement.executeQuery();
            int minionId = 0;
            if (minionResult.next()){
                minionId = minionResult.getInt("minion_id");
                selectMinionStatement.close();
            }

            PreparedStatement insertMapStatement = connection.prepareStatement(insertMapQuery);
            insertMapStatement.setInt(1, minionId);
            insertMapStatement.setInt(2, villainId);
            insertMapStatement.executeUpdate();
            System.out.printf("Successfully added %s to be minion of %s", minionName, villainName);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
