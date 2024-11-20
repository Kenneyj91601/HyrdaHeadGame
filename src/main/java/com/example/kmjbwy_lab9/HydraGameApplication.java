package com.example.kmjbwy_lab9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HydraGameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /*
        HydraHead head1 = HydraHeadsfactory.getHead(1);
        HBox hB = new HBox(head1.imageView);
        Scene scene = new Scene(hB);
        stage.setScene(scene);
        stage.setTitle("Hydra");
        stage.show();
        */

        FXMLLoader fxmlloader = new FXMLLoader(HydraGameApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 800, 850);
        stage.setScene(scene);
        stage.setTitle("Hydra Game");
        stage.getIcons().add(new Image("file:src/main/resources/HydraHeads/HydraIcon.png"));
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}