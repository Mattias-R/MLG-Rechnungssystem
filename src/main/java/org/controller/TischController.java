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
import org.klassen.Speisen;
import org.klassen.Tisch;



public class TischController {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");
    public TextField tableID;
    public static ArrayList arr = new ArrayList();

    public void initialize(){
        tableID.setText(Tisch.ausgewaehlterTisch);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Hauptspeisen.txt"))) {

            while (scanner.hasNext()){
                arr.add(scanner.next());
                System.out.println(scanner.next());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(arr);
    }


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


    public void selectTableNumber(Event event){
        Tisch.ausgewaehlterTisch = ((Control)event.getSource()).getId().substring(5);
        tableID.setText(Tisch.ausgewaehlterTisch);
    }

}