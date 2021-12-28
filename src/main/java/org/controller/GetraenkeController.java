package org.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import org.klassen.Entry;
import org.klassen.Getraenke;
import org.klassen.Tisch;

import java.io.IOException;

public class GetraenkeController {
    public TextField getraenkeTischID;
    public GridPane getraenkeGrid;
    public TextField getraenkeAnzahl;
    public TextField getraenkeEingabe;
    public TableView getraenkeAnzeigeTafel;
    public TableColumn<ObservableList<Entry>, String> tableViewAnzahl;
    public TableColumn<ObservableList<Entry>, String> tableViewArtikel;
    public TableColumn<ObservableList<Entry>, String> tableViewPreis;

    public void initialize(){
        getraenkeTischID.setText(Tisch.ausgewaehlterTisch);
        tableViewAnzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableViewArtikel.setCellValueFactory(new PropertyValueFactory<>("artikel"));
        tableViewPreis.setCellValueFactory(new PropertyValueFactory<>("preis"));

        int counter = 0;
        for(int i = 0; i <= 6; i++){
            for(int y = 0; y < 4; y++){
                //create AnchorPane and Buttons
                AnchorPane zentrierFeld = new AnchorPane();
                Button button = new Button();


                try {
                    //set button text
                    int param = App.alkoholfreiListe.get(counter).toString().indexOf(";");
                    button.setText(App.alkoholfreiListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            getraenkeEingabe.setText(button.getText());
                            //System.out.println(button.getText());
                        }
                    });

                    //poistion hierarchy
                    button.setMinSize(156,120);
                    VBox gridbox = new VBox();
                    getraenkeGrid.add(gridbox,y,i);
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
                    getraenkeGrid.setAlignment(Pos.CENTER);


                } catch(Exception e){
                    //System.out.println(e);
                }

                counter++;
            }

        }

    }



    public void displayNichtAlkohol(){
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{
                    //System.out.println(y + "" + i);
                    getraenkeGrid.getChildren().clear();
                    // speisenGrid.getChildren().remove(i,y);
                }catch (Exception e) {

                    //System.out.println(e);
                    //System.out.println(y + "hi" + i);
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
                    int param = App.alkoholfreiListe.get(counter).toString().indexOf(";");
                    button.setText(App.alkoholfreiListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            getraenkeEingabe.setText(button.getText());
                            //System.out.println(button.getText());
                        }
                    });

                    //poistion hierarchy
                    button.setMinSize(156,120);
                    VBox gridbox = new VBox();
                    getraenkeGrid.add(gridbox,y,i);
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
                    getraenkeGrid.setAlignment(Pos.CENTER);


                } catch(Exception e){
                    //System.out.println(e);
                }

                counter++;
            }


        }
    }

    public void displayAlkohol(){
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{
                    //System.out.println(y + "" + i);
                    getraenkeGrid.getChildren().clear();
                    // speisenGrid.getChildren().remove(i,y);
                }catch (Exception e) {

                    //System.out.println(e);
                    //System.out.println(y + "hi" + i);
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
                    int param = App.alkoholListe.get(counter).toString().indexOf(";");
                    button.setText(App.alkoholListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            getraenkeEingabe.setText(button.getText());
                            //System.out.println(button.getText());
                        }
                    });

                    //poistion hierarchy
                    button.setMinSize(156,120);
                    VBox gridbox = new VBox();
                    getraenkeGrid.add(gridbox,y,i);
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
                    getraenkeGrid.setAlignment(Pos.CENTER);


                } catch(Exception e){
                    //System.out.println(e);
                }

                counter++;
            }


        }
    }

    public void displayKaffee(){
        int counter = 0;
        for(int i = 0; i <= 6; i++) {
            for (int y = 0; y < 4; y++) {
                try{
                    //System.out.println(y + "" + i);
                    getraenkeGrid.getChildren().clear();
                    // speisenGrid.getChildren().remove(i,y);
                }catch (Exception e) {

                    //System.out.println(e);
                    //System.out.println(y + "hi" + i);
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
                    int param = App.kaffeeListe.get(counter).toString().indexOf(";");
                    button.setText(App.kaffeeListe.get(counter).toString().replace(".", " ").substring(0, param));

                    //button functions
                    button.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            getraenkeEingabe.setText(button.getText());
                            //System.out.println(button.getText());
                        }
                    });

                    //poistion hierarchy
                    button.setMinSize(156,120);
                    VBox gridbox = new VBox();
                    getraenkeGrid.add(gridbox,y,i);
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
                    getraenkeGrid.setAlignment(Pos.CENTER);


                } catch(Exception e){
                    //System.out.println(e);
                }

                counter++;
            }


        }
    }



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

    public void selectQuantityGetraenke(Event event){
        getraenkeAnzahl.setText(((Control)event.getSource()).getId().substring(3));
    }

    public void deleteGetraenke(){
        int anzahl = Integer.parseInt(getraenkeAnzahl.getText());
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                for (Getraenke getraenk : Getraenke.getraenkeList) {
                    if (getraenkeEingabe.getText().equals(getraenk.name) && tisch.konsumation.contains(getraenk)) {
                        tisch.artikelLoeschen(getraenk, anzahl);
                    }
                }
            }
        }
    }

    public void getraenkeZuTischHinzufuegen(){
        int anzahl = Integer.parseInt(getraenkeAnzahl.getText());
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                for (Getraenke getraenk : Getraenke.getraenkeList) {
                    if (getraenkeEingabe.getText().equals(getraenk.name)) {
                        tisch.artikelHinzufuegen(getraenk, anzahl);
                        tisch.showKonsumation();
                        tisch.addToTableView(getraenkeAnzeigeTafel, getraenk, anzahl);
                    }
                }
            }
        }
    }

}
