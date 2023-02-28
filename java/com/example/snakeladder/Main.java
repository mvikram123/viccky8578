package com.example.snakeladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root;
    @Override
    public void start(Stage stage) throws IOException {
        root = new Group();
        GamePage page=new GamePage();
        root.getChildren().add(page.root);
       // Parent root = FXMLLoader.load(Main.class.getResource("GamePage.fxml"));
        stage.setScene(new Scene(root,650,520));
        stage.setTitle("Snake & Ladder!");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}