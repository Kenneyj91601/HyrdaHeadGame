package com.example.kmjbwy_lab9;

//Imports
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
    //FXML private methods
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

    //Utility private methods
    private final List<int[]> gridCoordinates = new ArrayList<>();
    private int currentCoordinate = 0;
    private static final int gridSize = 16;
    private boolean isGridSetUp = false;
    private int clickCounter;

    //Method for  setting up the coordinates in the gridCoordinates array
    private void setupCoordinates(){
        for(int i = 0; i < gridSize; i++){
            for(int j = 0; j < gridSize; j++){
                gridCoordinates.add(new int[]{i, j});
            }
        }
        Collections.shuffle(gridCoordinates);
    }

    //Method for setting up the grid
    private void setupGrid() {
        if (isGridSetUp) {
            System.out.println("Grid is already set up.");
            return;
        }
            System.out.println("setting up grid...");


            isGridSetUp = true;
        }

    //Method for handling when a user clicks a head image
    private void imageClick(MouseEvent event, ImageView imageView, HydraHead head) {
        gridPane.getChildren().remove(imageView);
        killHead(head, currentCoordinate);
        clickCounter++;
    }

    //Method for the Play button
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

    //Method for the Reset button
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

    //Tried our best to implement this function, but we had no idea what importance it had in the rest of the code
    //We left it blank because we were confused on the method Name and what connection a mouse click and the head size was supposed to have
    private void setHeadSize(MouseEvent event){
        return;
    }

    //Method for making the initial head of the chosen head size appear on the grid
    //Also puts that first head in the coordinates of the first element in the gridCoordinates array
    private void playGrid(int size){
            HydraHead head = HydraHeadsfactory.getHead(size);
            ImageView imageView = head.getImageView();

            imageView.setOnMouseClicked(event -> imageClick(event, head.getImageView(), head));

            //Add head to a random spot
            int[] coordinates = gridCoordinates.get(currentCoordinate);
            head.putIn(coordinates[0], coordinates[1], gridPane);
            currentCoordinate++;
            System.out.println(gridCoordinates.size());

        return;
    }

    //This method contains the logic for clicking a head and having 2 or 3 more heads spawn randomly
    //on the grid with the same imageClick instructions
    private void killHead(HydraHead head, int gridSpace) {
        if(head.getHeadSize()!=1) {
            Random random = new Random();
            int randNum = random.nextInt(2)+2;

            int currentSpace = gridSpace;

            for (int i = 0; i < randNum; i++) {
                HydraHead head1 = HydraHeadsfactory.getHead(head.getHeadSize() - 1);

                int x = gridCoordinates.get(currentSpace)[0];
                int y = gridCoordinates.get(currentSpace)[1];

                ImageView imageView = head1.getImageView();
                imageView.setOnMouseClicked(event -> imageClick(event, head1.getImageView(), head1));

                head1.putIn(x, y, gridPane);
                currentSpace++;
            }
            currentCoordinate = currentSpace;
        }
        if(gridPane.getChildren().isEmpty()){
            counterLabel.setVisible(true);
            counterLabel.setText("      Good Job! You clicked "+ clickCounter +" Heads!\nPress Reset or SpaceBar To Play Again");
        }
    }
}
