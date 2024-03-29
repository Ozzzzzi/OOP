package ru.nsi.fit.g18213.tromenshleger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The class represents the application itself. It has one method to start the application.
 */
public class MainMenu extends Application {
    private static final int WIDTH = 750;
    private static final int HEIGHT = 750;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("/views/MainMenuView.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(Objects.requireNonNull(root), WIDTH, HEIGHT));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();

        primaryStage.show();
    }
}