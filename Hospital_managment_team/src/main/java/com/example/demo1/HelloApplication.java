package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load FXML files for the three graphs
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("VisInsurence.fxml"));
        FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("VisTestResults.fxml"));
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("Vis3FreqTest.fxml"));
        /// / ikrame ghraphes !!!!
        FXMLLoader fxmlLoader4 = new FXMLLoader(HelloApplication.class.getResource("NumberPatientIKR.fxml"));
        FXMLLoader fxmlLoader5 = new FXMLLoader(HelloApplication.class.getResource("AppointmentNumber.fxml"));


        /// / khadija
        FXMLLoader fxmlLoader6 = new FXMLLoader(HelloApplication.class.getResource("TestResult.fxml"));
        FXMLLoader fxmlLoader7 = new FXMLLoader(HelloApplication.class.getResource("InsuranceClaims.fxml"));
        FXMLLoader fxmlLoader8 = new FXMLLoader(HelloApplication.class.getResource("GenderAgeChart.fxml"));

        // Create tabs for each graph
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Insurance Graph", fxmlLoader1.load());
        tab1.setClosable(false); // Disable tab closing
        Tab tab2 = new Tab("Test Results Graph", fxmlLoader2.load());
        tab2.setClosable(false);
        Tab tab3 = new Tab("Frequency Test Graph", fxmlLoader3.load());
        tab3.setClosable(false);
        /// ///
        Tab tab4 = new Tab("Number of patient Per Year", fxmlLoader4.load());
        tab4.setClosable(false);
        Tab tab5 = new Tab("Number of Appointemtns", fxmlLoader5.load());
        tab4.setClosable(false);


        /// //


        Tab tab6 = new Tab("Average Processing Time of Health Tests", fxmlLoader6.load());
        tab4.setClosable(false);
        Tab tab7 = new Tab("Insurance Claims Evolution", fxmlLoader7.load());
        tab4.setClosable(false);
        Tab tab8 = new Tab("Age and Gender Distribution", fxmlLoader8.load());
        tab4.setClosable(false);




        // Add tabs to the TabPane
        tabPane.getTabs().addAll(tab1, tab2, tab3 , tab4 , tab5, tab6, tab7, tab8);

        // Set up the scene and stage
        Scene scene = new Scene(tabPane, 800, 600);
        stage.setTitle("Graphs Viewer");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        // Close the database connection when the application stops
       // DatabaseConnection.closeConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}
