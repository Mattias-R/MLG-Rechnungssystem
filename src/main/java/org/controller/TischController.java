package org.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.klassen.Tisch;



public class TischController {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");
    public Button Tisch1;
    public Button Tisch2;
    public Button Tisch3;
    public Button Tisch4;
    public Button Tisch5;
    public Button Tisch6;
    public Button Tisch7;
    public Button Tisch8;
    public Button Tisch9;
    public Button Tisch10;
    public Button Tisch11;
    public Button Tisch12;
    public Button Tisch13;
    public Button Tisch14;
    public Button Tisch15;
    public Button Tisch16;
    public Button Tisch17;
    public Button Tisch18;
    public Button Tisch19;
    public Button Tisch20;
    public Button Tisch21;
    public Button Tisch22;
    public Button Tisch23;
    public Button Tisch24;
    public Button Tisch25;


    public void test1 (){
        designerMattias = (GridPane) scene.lookup("#gridpanetable");
        designerMattias.add(peter,4,4);
        System.out.println("hallo");
    }
    @FXML
    public void switchToSpeisen() throws IOException{
            App.setRoot("speisen");
    }
    @FXML
    public void switchToGetraenke() throws IOException{
        App.setRoot("getraenke");
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

    public void selectTableNumber(){

        for(Button button : Arrays.asList(Tisch1, Tisch2, Tisch3,Tisch4,Tisch5,Tisch6,Tisch7,Tisch8,Tisch9,Tisch10,Tisch11,Tisch12,Tisch13,Tisch14,Tisch15,Tisch16,Tisch17,Tisch18,Tisch19,Tisch20,Tisch21,Tisch22,Tisch23,Tisch24,Tisch25)){
            Tisch.ausgewaehlterTisch = button.getText().substring(3);
        }
        System.out.println(Tisch.ausgewaehlterTisch);
    }

}