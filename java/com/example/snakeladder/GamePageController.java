package com.example.snakeladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePageController {
    public static Group root;
   @FXML
    public void start(MouseEvent event) throws IOException {
      AnchorPane start = FXMLLoader.load(getClass().getResource("PlayArea.fxml"));
       Main.root.getChildren().setAll(start);


    }

}
