package com.example.snakeladder;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Random;


public class PlayAreaController {
    @FXML
    Text number;
    @FXML
    Text changeturn;
    @FXML
    ImageView player1;
    @FXML
    ImageView player2;
    int turn = 1;
    HashMap<Pair<Double, Double>, Pair<Double, Double>> snakeLadderCordinateschange;

    public void roll(MouseEvent e) {
        getSnakeLadderCoordinates();
        //  System.out.println("dice is rolling");
        Random random = new Random();
        int rolling = random.nextInt(6) + 1;

        // System.out.println(rolling);
        number.setText("" + rolling);
        // if (rolling != 6) {
        if (turn == 1) {

            Pair<Double, Double> moveCoordinates = movement(player1.getTranslateX(), player1.getTranslateY(), rolling);
            player1.setTranslateX(moveCoordinates.getKey());
            player1.setTranslateY(moveCoordinates.getValue());
            if (snakeLadderCordinateschange.containsKey(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())))

            {
                player1.setTranslateX(snakeLadderCordinateschange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getKey());
                player1.setTranslateY(snakeLadderCordinateschange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getValue());
            }
            checkWin(player1.getTranslateX(), player1.getTranslateY());

        } else {
            Pair<Double, Double> moveCoordinates = movement(player2.getTranslateX(), player2.getTranslateY(), rolling);
            player2.setTranslateX(moveCoordinates.getKey());
            player2.setTranslateY(moveCoordinates.getValue());
            if (snakeLadderCordinateschange.containsKey(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())))

            {
                player2.setTranslateX(snakeLadderCordinateschange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getKey());
                player2.setTranslateY(snakeLadderCordinateschange.get(new Pair<>(moveCoordinates.getKey(), moveCoordinates.getValue())).getValue());
            }
            checkWin(player2.getTranslateX(), player2.getTranslateY());


        }
        if (rolling != 6) {
            if (turn == 1) {
                turn = 2;
                changeturn.setText("2 's turn now");
            } else {
                turn = 1;
                changeturn.setText("1's turn");
            }
        }
    }

    Pair<Double, Double> movement(double X, double Y, int rolling) {
        double moveX = X;
        double moveY = Y;

        if (moveY % 100 == 0) {
            moveX += rolling * 50;
            if (moveX > 450) {
                moveX = 450 * 2 - moveX + 50;
                moveY -= 50;
            }
        } else {
            moveX -= rolling * 50;
            if (moveX < 50) {
                if (moveY == -450)
                    return (new Pair<>(X, Y));
                moveX = -1 * (moveX - 50);
                moveY -= 50;
            }

        }
        return new Pair<>(moveX, moveY);

    }

    void checkWin(double X, double y) {
        if (X == 50 && y == -450) {
            Alert wonalert = new Alert(Alert.AlertType.INFORMATION);
            wonalert.setContentText("result");
            if (turn == 1) {
                wonalert.setContentText("player 1 has won the game");
            } else {


                wonalert.setContentText("player 2 has won the game");
            }

            wonalert.showAndWait();
        }
    }


    void getSnakeLadderCoordinates()
    {
        snakeLadderCordinateschange =new HashMap<>();
        snakeLadderCordinateschange.put(new Pair<>(50.0,0.0),new Pair<>(150.0,-150.0));
        snakeLadderCordinateschange.put(new Pair<>(200.0,0.0),new Pair<>(350.0,-50.0));
        snakeLadderCordinateschange.put(new Pair<>(200.0,-50.0),new Pair<>(350.0,0.0));
        snakeLadderCordinateschange.put(new Pair<>(450.0,0.0),new Pair<>(500.0,-150.0));
        snakeLadderCordinateschange.put(new Pair<>(400.0,-100.0),new Pair<>(200.0,-400.0));
        snakeLadderCordinateschange.put(new Pair<>(50.0,-100.0),new Pair<>(100.0,-200.0));
        snakeLadderCordinateschange.put(new Pair<>(200.0,-300.0),new Pair<>(50.0,-250.0));


        snakeLadderCordinateschange.put(new Pair<>(350.0,-350.0),new Pair<>(350.0,-150.0));
        snakeLadderCordinateschange.put(new Pair<>(500.0,-250.0),new Pair<>(350.0,-300.0));
        snakeLadderCordinateschange.put(new Pair<>(100.0,-300.0),new Pair<>(100.0,-50.0));
        snakeLadderCordinateschange.put(new Pair<>(50.0,-350.0),new Pair<>(50.0,-450.0));

        snakeLadderCordinateschange.put(new Pair<>(350.0,-400.0),new Pair<>(200.0,-100.0));
        snakeLadderCordinateschange.put(new Pair<>(400.0,-450.0),new Pair<>(400.0,-350.0));
        snakeLadderCordinateschange.put(new Pair<>(300.0,-450.0),new Pair<>(300.0,-350.0));
        snakeLadderCordinateschange.put(new Pair<>(150.0,-450.0),new Pair<>(100.0,-350.0));
       // snakeLadderCordinateschange.put(new Pair<>(350.0,-400.0),new Pair<>(200.0,-100.0));
    }
    }




