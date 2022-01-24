package org.controller;

import java.awt.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.klassen.Getraenke;
import org.klassen.Mitarbeiter;
import org.klassen.Speisen;
import org.klassen.Tisch;
import javax.swing.*;

public class TischController extends Component {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");
    public TextField tableID;
    public TextField datumZeit;

    public void initialize(){
        App.initClock(datumZeit);
        tableID.setText(Tisch.ausgewaehlterTisch);
    }

    public void test1 (){
        designerMattias = (GridPane) scene.lookup("#gridpanetable");
        designerMattias.add(peter,4,4);
    }
    @FXML
    public void switchToSpeisen() throws IOException{
        if (tableID.getText() != ""){
            App.setRoot("speisen");
            Speisen.showSpeisenList();
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Sie müssen einen Tisch auswählen um fortzufahren!", "Tisch auswählen", JOptionPane.ERROR_MESSAGE);
        }

    }
    @FXML
    public void switchToGetraenke() throws IOException{
        if (tableID.getText() != ""){
            App.setRoot("getraenke");
            Getraenke.printGetraenkeListe();
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Sie müssen einen Tisch auswählen um fortzufahren!", "Tisch auswählen", JOptionPane.ERROR_MESSAGE);
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