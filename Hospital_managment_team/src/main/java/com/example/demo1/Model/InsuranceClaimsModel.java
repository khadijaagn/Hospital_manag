package com.example.demo1.Model;

import com.example.demo1.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class InsuranceClaimsModel {

    // Méthode pour récupérer le nombre de réclamations par année
    public Map<String, Integer> getInsuranceClaimsByYear() {
        Map<String, Integer> claimsByYear = new HashMap<>();

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Requête SQL pour obtenir le nombre de réclamations d'assurance par année
            String query = "SELECT YEAR(DateReclamation) AS Year, COUNT(*) AS Claims " +
                    "FROM ReclamationAssurance " +
                    "GROUP BY YEAR(DateReclamation)";
            ResultSet resultSet = statement.executeQuery(query);

            // Traitement des résultats
            while (resultSet.next()) {
                String year = resultSet.getString("Year");
                int claims = resultSet.getInt("Claims");
                claimsByYear.put(year, claims);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return claimsByYear;
    }
}
