package com.example.kmjbwy_lab9;

import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HydraHead {
    private int headSize;
    private int currentGridX;
    private int currentGridY;
    public ImageView imageView;


    public HydraHead(Image image, int headSize) {
        this.headSize = headSize;
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(40);
        this.imageView.setFitHeight(40);

    }

    public int getHeadSize() {
        return headSize;
    }

    public int getGridX() {
        return currentGridX;
    }

    public int getGridY() {
        return currentGridY;
    }

    public void putIn(int gridX, int gridY, GridPane board) {
        currentGridX = gridX;
        currentGridY = gridY;
        board.add(imageView, currentGridX, currentGridY);
    }

}