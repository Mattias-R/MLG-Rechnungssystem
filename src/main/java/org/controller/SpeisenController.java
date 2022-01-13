package org.controller;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.klassen.Entry;
import org.klassen.Speisen;
import org.klassen.Tisch;


public class SpeisenController {
    Scene scene = App.getScene();
    public TextField speisenTableID;
    public GridPane speisenGrid;
    public TextField speisenEingabe;
    public TextField speisenAnzahl;
    public TableView speisenAnzeigeTafel;
    public TextField datumZeit;
    public TableColumn<ObservableList<Entry>, String> tableViewAnzahl;
    public TableColumn<ObservableList<Entry>, String> tableViewArtikel;
    public TableColumn<ObservableList<Entry>, String> tableViewPreis;

    public void initialize(){
        App.initClock(datumZeit);
        tableViewAnzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableViewArtikel.setCellValueFactory(new PropertyValueFactory<>("artikel"));
        tableViewPreis.setCellValueFactory(new PropertyValueFactory<>("preis"));

        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                tisch.showTableView(speisenAnzeigeTafel);
            }
        }

        //----------------------------------------------
        //set tableID to Tablenumber
        speisenTableID.setText(Tisch.ausgewaehlterTisch);
        int counter = 0;
        for(int i = 0; i <= 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();

                try {
                    //set button text
                    int param = App.hauptspeisenListe.get(counter).toString().indexOf(";");
                    button.setText(App.hauptspeisenListe.get(counter).toString().replace(".", " ").substring(0, param));
                    /**
                     *
                     */

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            speisenEingabe.setText(button.getText());
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

                }
                counter++;
            }
        }
    }

    public void displayVorspeise() {
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{
                    speisenGrid.getChildren().clear();
                }catch (Exception e) {

                }

            }
        }

        for(int i = 0; i <= 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();

                try {
                    //set button text
                    int param = App.vorspeisenListe.get(counter).toString().indexOf(";");
                    button.setText(App.vorspeisenListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            speisenEingabe.setText(button.getText());
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

                }

                counter++;
            }


        }
    }

    public void displayHauptspeise() {
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{

                    speisenGrid.getChildren().clear();

                }catch (Exception e) {

                }

            }
        }

        for(int i = 0; i <= 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();

                try {
                    //set button text
                    int param = App.hauptspeisenListe.get(counter).toString().indexOf(";");
                    button.setText(App.hauptspeisenListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            speisenEingabe.setText(button.getText());
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

                }

                counter++;
            }
        }
    }

    public void displayNachspeise() {
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{
                    speisenGrid.getChildren().clear();
                }catch (Exception e) {

                }
            }
        }

        for(int i = 0; i <= 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();


                try {
                    //set button text
                    int param = App.nachspeisenListe.get(counter).toString().indexOf(";");
                    button.setText(App.nachspeisenListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            speisenEingabe.setText(button.getText());
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

                }
                counter++;
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
    }
    @FXML
    private void switchToRechnung() throws IOException {
        App.setRoot("rechnung");
    }

    public void selectQuantitySpeisen(Event event){
        speisenAnzahl.setText(((Control)event.getSource()).getId().substring(6));
    }

    public void deleteSpeisen(){
        //int anzahl = Integer.parseInt(speisenAnzahl.getText());
        int x = speisenAnzeigeTafel.getSelectionModel().getSelectedIndex();
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                tisch.data.remove(x);
                for (Speisen speise : Speisen.speisenListe) {
                    if (speisenEingabe.getText().equals(speise.name) && tisch.konsumation.contains(speise)) {
                        //tisch.artikelLoeschen(speise, anzahl);
                    }
                }
            }
        }
    }

    public void speisenZuTischHinzufuegen() {
        int anzahl = Integer.parseInt(speisenAnzahl.getText());
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                for (Speisen speise : Speisen.speisenListe) {
                    if (speisenEingabe.getText().equals(speise.name)) {
                        tisch.artikelHinzufuegen(speise, anzahl);
                        tisch.showKonsumation();
                        tisch.addToTableView(speisenAnzeigeTafel, speise, anzahl, 0.1);
                    }
                }
            }
        }
    }

    public TextField getSpeisenEingabe() {
        return speisenEingabe;
    }

    public void setSpeisenEingabe(TextField speisenEingabe) {
        this.speisenEingabe = speisenEingabe;
    }

    public TextField getSpeisenAnzahl() {
        return speisenAnzahl;
    }

    public void setSpeisenAnzahl(TextField speisenAnzahl) {
        this.speisenAnzahl = speisenAnzahl;
    }
}
