package com.example.kmjbwy_lab9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.input.MouseEvent;


public class HydraGameController {
    @FXML
    private Label welcomeText;
    @FXML
    private ImageView imageView2;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView pickerImage;
    @FXML
    private GridPane gridPane;
    @FXML
    private Slider headSizeSlider;


    private static final int gridSize = 16;
    private boolean isGridSetUp = false;

    public void setupGrid(int size) {
        if (isGridSetUp) {
            System.out.println("Grid is already set up.");
            return;
        }
            System.out.println("setting up grid...");

            HydraHead head = HydraHeadsfactory.getHead(size);
            ImageView imageView = new ImageView(head.imageView.getImage());
            imageView.setFitWidth(40);
            imageView.setPreserveRatio(true);

            imageView.setOnMouseClicked(event -> onClick(event, imageView));
            gridPane.add(imageView, 8, 8);

            isGridSetUp = true;
        }


    private void onClick(MouseEvent event, ImageView imageView) {
        gridPane.getChildren().remove(imageView);
    }

    @FXML
    private void Play(){
        int size = (int) headSizeSlider.getValue();
        HydraHead picker = HydraHeadsfactory.getHead(size);
        pickerImage.setImage(picker.imageView.getImage());
        setupGrid(size);
    }

    @FXML
    private void Reset(){
        headSizeSlider.setValue(4);
        gridPane.getChildren().clear();
        isGridSetUp = false;
        Play();
    }
}
