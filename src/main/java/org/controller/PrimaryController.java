package org.controller;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import org.klassen.Mitarbeiter;
import org.klassen.Speisen;

import javax.swing.*;

public class PrimaryController extends Component {

    public static Mitarbeiter eingeloggterMitarbeiter;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void loginAction(Event event) throws IOException{
        Optional<Mitarbeiter> eingeloggterMtb = verifiziereMitarbeiter(this.passwordField.getText());
        if (eingeloggterMtb.isPresent()){
            eingeloggterMitarbeiter = eingeloggterMtb.get();
            App.setRoot("tisch");
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Sie müssen einen korrekten und bestehenden PIN eingeben!", "Falscher PIN", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Optional<Mitarbeiter> verifiziereMitarbeiter(String pin) {
        return Mitarbeiter.mitarbeiterList.stream().filter(mtb -> mtb.getPin().equals(pin)).findFirst();
    }

}
