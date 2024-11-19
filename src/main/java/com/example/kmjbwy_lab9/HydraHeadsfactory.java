package com.example.kmjbwy_lab9;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HydraHeadsfactory {
    private static Image headSize1 = new Image("file:src/main/resources/HydraHeads/HeadSize1.png");
    private static Image headSize2 = new Image("file:src/main/resources/HydraHeads/HeadSize2.png");
    private static Image headSize3 = new Image("file:src/main/resources/HydraHeads/HeadSize3.png");
    private static Image headSize4 = new Image("file:src/main/resources/HydraHeads/HeadSize4.png");
    private static Image headSize5 = new Image("file:src/main/resources/HydraHeads/HeadSize5.png");
    private static Image headSize6 = new Image("file:src/main/resources/HydraHeads/HeadSize6.png");

    private HydraHeadsfactory(){}

     public static HydraHead getHead(int size){
        if (size == 1){
            return new HydraHead(headSize1, 1);
        }
        else if (size == 2){
            return new HydraHead(headSize2, 2);
        }
         else if (size == 3){
            return new HydraHead(headSize3, 3);
         }
        else if (size == 4){
            return new HydraHead(headSize4, 4);
        }
        else if (size == 5){
            return new HydraHead(headSize5, 5);
        }
        else{
            return new HydraHead(headSize6, 6);
        }
         //Image image = new Image("file:src/main/resources/HydraHeads/HeadSize1.png");
         //ImageView imageView = new ImageView(image);

     }

}
