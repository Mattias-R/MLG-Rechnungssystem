package org.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.klassen.Tisch;



public class TischController {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");
    public static TextField tableID;

    public void test1 (){
        designerMattias = (GridPane) scene.lookup("#gridpanetable");
        designerMattias.add(peter,4,4);
        System.out.println("hallo");
    }
    @FXML
    public void switchToSpeisen() throws IOException{

            App.setRoot("speisen");
        tableID.setText(Tisch.ausgewaehlterTisch);
    }
    @FXML
    public void switchToGetraenke() throws IOException{

        App.setRoot("getraenke");
        tableID.setText(Tisch.ausgewaehlterTisch);
    }

    @FXML
    private void switchToPrimary() throws IOException {

        App.setRoot("primary");
        tableID.setText(Tisch.ausgewaehlterTisch);
    }
    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("tisch");
        tableID.setText(Tisch.ausgewaehlterTisch);
    }

    public void test2(ActionEvent actionEvent) {
    designerMattias.getChildren().remove(peter);

    }


    public void selectTableNumber(Event event){
        System.out.println();
        Tisch.ausgewaehlterTisch = ((Control)event.getSource()).getId().substring(5);
        tableID.setText(Tisch.ausgewaehlterTisch);
        System.out.println(Tisch.ausgewaehlterTisch);

    }


}