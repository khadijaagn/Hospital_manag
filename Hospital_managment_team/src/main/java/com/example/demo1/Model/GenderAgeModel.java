package com.example.demo1.Model;

import com.example.demo1.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GenderAgeModel {

    // Méthode pour récupérer les groupes d'âge par sexe
    public Map<String, Map<String, Integer>> getAgeGroupsBySex() {
        Map<String, Map<String, Integer>> ageGroups = new HashMap<>();
        ageGroups.put("Male", new HashMap<>());
        ageGroups.put("Female", new HashMap<>());

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Requête SQL pour obtenir les patients et calculer leur âge
            String query = "SELECT Sexe, FLOOR(DATEDIFF(CURDATE(), BirthDate) / 365) AS Age FROM Patient";
            ResultSet resultSet = statement.executeQuery(query);

            // Traitement des résultats de la base de données
            while (resultSet.next()) {
                String sex = resultSet.getString("Sexe");
                int age = resultSet.getInt("Age");

                // Calcul du groupe d'âge sous forme de chaîne
                String ageGroup = (age / 10) * 10 + "-" + ((age / 10) * 10 + 9);

                // Mise à jour des groupes d'âge pour chaque sexe
                if (sex.equalsIgnoreCase("Male")) {
                    ageGroups.get("Male").put(ageGroup, ageGroups.get("Male").getOrDefault(ageGroup, 0) + 1);
                } else if (sex.equalsIgnoreCase("Female")) {
                    ageGroups.get("Female").put(ageGroup, ageGroups.get("Female").getOrDefault(ageGroup, 0) + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ageGroups;
    }
}
