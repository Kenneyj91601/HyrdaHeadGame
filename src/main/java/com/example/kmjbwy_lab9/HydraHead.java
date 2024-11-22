package com.example.kmjbwy_lab9;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HydraHead {
    //private variables for HydraHead
    private int headSize;
    private int currentGridX;
    private int currentGridY;
    private ImageView imageView;

    //Constructor
    public HydraHead(Image image, int headSize) {
        this.headSize = headSize;
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(40);
        this.imageView.setFitHeight(40);

    }

    //returns the headSize of a head
    public int getHeadSize() {
        return headSize;
    }

    //returns the image view for each head
    public ImageView getImageView() {
        return imageView;
    }

    //returns the x-axis grid spot
    public int getGridX() {
        return currentGridX;
    }

    //returns the y-axis grid spot
    public int getGridY() {
        return currentGridY;
    }

    //inserts a hydra head into a spot in the given the grid pane board
    public void putIn(int gridX, int gridY, GridPane board) {
        currentGridX = gridX;
        currentGridY = gridY;
        board.add(imageView, currentGridX, currentGridY);
    }

}