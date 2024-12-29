package com.example.demo1.Model;

import com.example.demo1.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test_traitResultModel {

    public double getAverageProcessingTime() {
        double averageTime = 0.0;
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Requête SQL pour calculer la moyenne

            String query = "SELECT AVG(TIMESTAMPDIFF(HOUR, DateEffectue, ResultDate)) AS AverageProcessingTime FROM TestResult";

            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                averageTime = resultSet.getDouble("AverageProcessingTime");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return averageTime;
    }
}
