package org.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.klassen.Getraenke;
import org.klassen.Speisen;
import org.klassen.Tisch;



public class TischController {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");
    public TextField tableID;

    public void initialize(){
        tableID.setText(Tisch.ausgewaehlterTisch);
    }

    public void test1 (){
        designerMattias = (GridPane) scene.lookup("#gridpanetable");
        designerMattias.add(peter,4,4);
        //System.out.println("hallo");
    }
    @FXML
    public void switchToSpeisen() throws IOException{
        if (tableID.getText() != ""){
            App.setRoot("speisen");
            //System.out.println(tableID.getText());
            //Speisen.createSpeisenList();
            Speisen.showSpeisenList();
        }else{
            System.out.println("Wählen sie einen Tisch aus");
        }

    }
    @FXML
    public void switchToGetraenke() throws IOException{
        if (tableID.getText() != ""){
            App.setRoot("getraenke");
            Getraenke.printGetraenkeListe();
        }else{
            System.out.println("Wählen sie einen Tisch aus");
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("tisch");
    }

    public void test2(ActionEvent actionEvent) {
    designerMattias.getChildren().remove(peter);

    }

    public void selectTableNumber(Event event){
        Tisch.ausgewaehlterTisch = ((Control)event.getSource()).getId().substring(5);
        tableID.setText(Tisch.ausgewaehlterTisch);
        //Test
        Tisch neu = new Tisch(Integer.parseInt(Tisch.ausgewaehlterTisch));
        Tisch.tischListe.add(neu);
    }


}