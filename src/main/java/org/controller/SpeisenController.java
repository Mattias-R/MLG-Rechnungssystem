package org.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Scene;

public class SpeisenController {
    Scene scene = App.getScene();


    @FXML
    public void switchToSpeisen() throws IOException{
        App.setRoot("speisen");
    }
    @FXML
    public void switchToGetraenke() throws IOException{
        App.setRoot("getraenke");
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("tisch");
        //hallo goran
        //zweites
    }
    @FXML
    private void switchToRechnung() throws IOException {
        App.setRoot("rechnung");
        //hallo goran
        //zweites
    }
}
