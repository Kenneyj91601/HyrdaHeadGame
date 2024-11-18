package com.example.kmjbwy_lab9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HydraGameController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Nigga");
    }
}