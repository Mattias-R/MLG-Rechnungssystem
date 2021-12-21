package org.controller;

import javafx.fxml.FXML;

import java.io.IOException;

public class GetraenkeController {

    @FXML
    public void switchToSpeisen() throws IOException {
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
