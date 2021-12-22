package org.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.klassen.Tisch;

public class SpeisenController {
    Scene scene = App.getScene();
    public TextField speisenTableID;
    public GridPane speisenGrid;

    public void initialize(){
        speisenTableID.setText(Tisch.ausgewaehlterTisch);
        speisenGrid.setAlignment(Pos.CENTER);
        //speisenGrid.setStyle("-fx-background-color: black");
        for(int i = 0; i < 4; i++){
            for(int y = 0; y < 6; y++){
                Button button = new Button();
                button.setText("i: " +i + " y: " + y);
                button.setAlignment(Pos.CENTER);
                button.setMinSize(156,120);
                //button.setMinHeight(120);
                //button.setMinWidth(156);
                VBox gridbox = new VBox();
                if(y == 0){
                    gridbox.setAlignment(Pos.CENTER);
                    gridbox.setStyle("-fx-background-color: black");
                }else{
                    gridbox.setAlignment(Pos.TOP_CENTER);
                    gridbox.setStyle("-fx-background-color: green");
                }
                speisenGrid.add(gridbox,i,y);
                gridbox.getChildren().add(button);
                speisenGrid.setAlignment(Pos.CENTER);
            }
        }
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
