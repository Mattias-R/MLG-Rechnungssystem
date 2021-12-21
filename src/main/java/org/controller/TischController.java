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
    public static Button Tisch1;
    public static Button Tisch2;
    public static Button Tisch3;
    public static Button Tisch4;
    public static Button Tisch5;
    public static Button Tisch6;
    public static Button Tisch7;
    public static Button Tisch8;
    public static Button Tisch9;
    public static Button Tisch10;
    public static Button Tisch11;
    public static Button Tisch12;
    public static Button Tisch13;
    public static Button Tisch14;
    public static Button Tisch15;
    public static Button Tisch16;
    public static Button Tisch17;
    public static Button Tisch18;
    public static Button Tisch19;
    public static Button Tisch20;
    public static Button Tisch21;
    public static Button Tisch22;
    public static Button Tisch23;
    public static Button Tisch24;
    public static Button Tisch25;


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
        System.out.println();
        /*
        for(Button button : Arrays.asList(Tisch1, Tisch2, Tisch3,Tisch4,Tisch5,Tisch6,Tisch7,Tisch8,Tisch9,Tisch10,Tisch11,Tisch12,Tisch13,Tisch14,Tisch15,Tisch16,Tisch17,Tisch18,Tisch19,Tisch20,Tisch21,Tisch22,Tisch23,Tisch24,Tisch25)){
            Tisch.ausgewaehlterTisch = button.getText().substring(3);
        }

 */
        System.out.println(Tisch.ausgewaehlterTisch);
    }


}