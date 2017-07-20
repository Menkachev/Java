package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class RemoveVillain {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db";
    private static final String USERNAME  = "root";
    private static final String PASSWORD = "0651001";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer villainId = Integer.parseInt(reader.readLine());

        String deleteFromMapTable = "DELETE FROM minions_villains WHERE villains_id = ?";
        String deleteFromVillains = "DELETE FROM villains WHERE villains_id = ?";
        String selectVillain = "SELECT * FROM villains WHERE villains_id = ?";

         try (
                 Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 ){
             PreparedStatement selectVillainStatement = connection.prepareStatement(selectVillain);
             selectVillainStatement.setInt(1, villainId);
             ResultSet villainResult = selectVillainStatement.executeQuery();

             if (villainResult.next()){

                 String villainName = villainResult.getString("name");

                 PreparedStatement deleteFromMapStatement = connection.prepareStatement(deleteFromMapTable);
                 deleteFromMapStatement.setInt(1, villainId);
                 int minionsCount = deleteFromMapStatement.executeUpdate();
                 deleteFromMapStatement.close();

                 PreparedStatement deleteFromVillainStatement = connection.prepareStatement(deleteFromVillains);
                 deleteFromVillainStatement.setInt(1, villainId);
                 deleteFromVillainStatement.executeUpdate();

                 System.out.printf("%s was deleted\n", villainName);
                 System.out.printf("%d minions released\n", minionsCount);

             } else {
                 System.out.println("No such villain was found");
             }

         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
