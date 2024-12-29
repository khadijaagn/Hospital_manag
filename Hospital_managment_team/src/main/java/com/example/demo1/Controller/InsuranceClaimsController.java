package com.example.demo1.Controller;

import com.example.demo1.Model.InsuranceClaimsModel;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.util.Map;

public class InsuranceClaimsController {

    @FXML
    private LineChart<String, Number> lineChart;

    private InsuranceClaimsModel insuranceClaimsModel;

    public void initialize() {
        // Initialiser le modèle
        insuranceClaimsModel = new InsuranceClaimsModel();

        // Récupérer le nombre de réclamations par année
        Map<String, Integer> claimsByYear = insuranceClaimsModel.getInsuranceClaimsByYear();

        // Créer la série pour le graphique
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Insurance Claims");

        // Ajouter les données à la série
        claimsByYear.forEach((year, claims) ->
                series.getData().add(new XYChart.Data<>(year, claims)));

        // Ajouter la série au graphique
        lineChart.getData().add(series);
        lineChart.setLegendVisible(false);

    }
}
