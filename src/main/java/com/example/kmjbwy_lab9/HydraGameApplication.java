package com.example.kmjbwy_lab9;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HydraGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HydraHead head1 = HydraHeadsfactory.getHead(1);

    }

    public static void main(String[] args) {
        launch();
    }
}