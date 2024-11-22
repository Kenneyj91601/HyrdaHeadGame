/*
    GROUP #9
    Kenneth Jackson: kmjbwy
    Praise Aruwajoye: ipahrp
    Amari Childs: alcnpg
 */

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

        //Application Loader and Start
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