package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Set the title of the window
        primaryStage.setTitle("Metric Converter");

        // Create UI components
        Label instructionLabel = new Label("Welcome to Metric Converter!");
        Label promptLabel = new Label("Enter your query (e.g., 1 km = m) and press Submit:");
        Label resultLabel = new Label();
        TextField inputField = new TextField();
        Button submitButton = new Button("Submit");
        Button exitButton = new Button("Exit");

        // Set up event handling for the Submit button
        submitButton.setOnAction(e -> {
            String query = inputField.getText().trim();
            String result;

            switch (query) {
                case "1 kg = lb":
                    result = "1 kg = 2.2 lb.";
                    break;
                case "1 km = m":
                    result = "1 km = 1000 m.";
                    break;
                case "1 lb = kg":
                    result = "1 lb = 0.45 kg.";
                    break;
                default:
                    result = "Your input is not currently handled by this app.\n"
                           + "Please input another query, for example, 1 kg = lb.";
                    break;
            }

            resultLabel.setText(result);
        });

        // Set up event handling for the Exit button
        exitButton.setOnAction(e -> primaryStage.close());

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
            instructionLabel, 
            promptLabel, 
            inputField, 
            submitButton, 
            resultLabel, 
            exitButton
        );

        // Create a scene and display it
        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}