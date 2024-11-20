package com.example.kmjbwy_lab9;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;


public class HydraGameController {
    @FXML
    private GridPane gridPane;
    @FXML
    private Slider headSizeSlider;
    @FXML
    private Button Play;
    @FXML
    private Label counterLabel;
    @FXML
    private Label chosenSize;



    private List<int[]> gridCoordinates = new ArrayList<>();
    private int currentCoordinate = 0;

    private static final int gridSize = 16;
    private boolean isGridSetUp = false;
    private int clickCounter;

    private void setupCoordinates(){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                gridCoordinates.add(new int[]{i, j});
            }
        }
        Collections.shuffle(gridCoordinates);
    }

    private void setupGrid() {
        if (isGridSetUp) {
            System.out.println("Grid is already set up.");
            return;
        }
            System.out.println("setting up grid...");


            isGridSetUp = true;
        }


    private void imageClick(MouseEvent event, ImageView imageView, HydraHead head) {
        gridPane.getChildren().remove(imageView);
        killHead(head, currentCoordinate);
        clickCounter++;
    }

    @FXML
    private void Play(){
        Play.setDisable(true);
        counterLabel.setVisible(false);
        chosenSize.setText("Head Size: "+(int) headSizeSlider.getValue());
        int size = (int) headSizeSlider.getValue();
        setupCoordinates();
        setupGrid();
        playGrid(size);
        clickCounter=1;
    }

    @FXML
    private void Reset(){
        Play.setDisable(false);
        chosenSize.setText("Head Size:");
        System.out.println("Reset Pressed...");
        headSizeSlider.setValue(4);
        gridPane.getChildren().clear();
        gridCoordinates.clear();
        isGridSetUp = false;
        counterLabel.setText("Choose a Head Size and Press Play...");
        //Play();
    }

    private void setHeadSize(MouseEvent event){
        return;
    }

    private void playGrid(int size){
            HydraHead head = HydraHeadsfactory.getHead(size);
            ImageView imageView = head.imageView;

            imageView.setOnMouseClicked(event -> imageClick(event, head.imageView, head));

            //Add head to a random spot
            int[] coordinates = gridCoordinates.get(currentCoordinate);
            head.putIn(coordinates[0], coordinates[1], gridPane);
            currentCoordinate++;
            System.out.println(gridCoordinates.size());

            if(gridPane.getChildren().isEmpty()){

            }


        return;
    }

    private void killHead(HydraHead head, int gridSpace) {
        if(head.getHeadSize()!=1) {
            Random random = new Random();
            int randNum = random.nextInt(2)+2;

            int currentSpace = gridSpace;

            for (int i = 0; i < randNum; i++) {
                HydraHead head1 = HydraHeadsfactory.getHead(head.getHeadSize() - 1);

                int x = gridCoordinates.get(currentSpace)[0];
                int y = gridCoordinates.get(currentSpace)[1];

                ImageView imageView = head1.imageView;
                imageView.setOnMouseClicked(event -> imageClick(event, head1.imageView, head1));

                head1.putIn(x, y, gridPane);
                currentSpace++;
            }
            currentCoordinate = currentSpace;
        }
        if(gridPane.getChildren().isEmpty()){
            counterLabel.setVisible(true);
            counterLabel.setText("Good Job! You clicked "+ clickCounter +" Heads!\n      Press Reset To Play Again");
        }
    }
}
