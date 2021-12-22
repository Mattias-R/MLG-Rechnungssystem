package org.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.klassen.Tisch;

public class SpeisenController {
    Scene scene = App.getScene();
    public TextField speisenTableID;
    public GridPane speisenGrid;
    public AnchorPane zentrierFeld;

    public void initialize(){
        //set tableID to Tablenumber
        speisenTableID.setText(Tisch.ausgewaehlterTisch);
        int counter = 0;
        for(int i = 0; i < 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();


                try {
                    //set button text
                    button.setText(App.arr.get(counter).toString());

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            System.out.println(button.getText());
                        }
                    });

                    //poistion hierarchy
                    button.setMinSize(156,120);
                    VBox gridbox = new VBox();
                    speisenGrid.add(gridbox,y,i);
                    gridbox.getChildren().add(zentrierFeld);
                    zentrierFeld.getChildren().add(button);

                    if(i == 0){
                        gridbox.setAlignment(Pos.CENTER);
                    }else{
                        gridbox.setAlignment(Pos.TOP_CENTER);
                    }

                    // Centralized buttons in grid
                    zentrierFeld.setBottomAnchor(button, 10.);
                    zentrierFeld.setLeftAnchor(button, 10.);
                    zentrierFeld.setRightAnchor(button, 10.);
                    zentrierFeld.setTopAnchor(button, 10.);
                    speisenGrid.setAlignment(Pos.CENTER);


                } catch(Exception e){
                    System.out.println(e);
                }

                counter++;
            }
            counter++;
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
