package org.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import org.klassen.Entry;
import org.klassen.Tisch;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;

public class RechnungController {
    public TextField rechnungTableID;
    public TableView rechnungAnzeigeTafel;
    public TableColumn<ObservableList<Entry>, String> tableViewAnzahl;
    public TableColumn<ObservableList<Entry>, String> tableViewArtikel;
    public TableColumn<ObservableList<Entry>, String> tableViewPreis;


    public void initialize(){
        rechnungTableID.setText(Tisch.ausgewaehlterTisch);
        tableViewAnzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableViewArtikel.setCellValueFactory(new PropertyValueFactory<>("artikel"));
        tableViewPreis.setCellValueFactory(new PropertyValueFactory<>("preis"));

        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                tisch.showTableView(rechnungAnzeigeTafel);
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
    private void alsPDFSpeichern() throws IOException {
        PDDocument pdfdoc= new PDDocument();
        pdfdoc.addPage(new PDPage());
        pdfdoc.save("C:\\Users\\Sample.pdf");
        System.out.println("PDF created");
        pdfdoc.close();
    }


}
