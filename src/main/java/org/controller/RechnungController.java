package org.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.klassen.Entry;
import org.klassen.Tisch;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RechnungController {
    public TextField rechnungTableID;
    public TextField datumZeit;
    public TableView rechnungAnzeigeTafel;
    public TableColumn<ObservableList<Entry>, String> tableViewAnzahl;
    public TableColumn<ObservableList<Entry>, String> tableViewArtikel;
    public TableColumn<ObservableList<Entry>, String> tableViewPreis;
    public static int Rechnungsnummer = 0;
    public TextField umsatzID;


    public void initialize(){
        App.initClock(datumZeit);

        rechnungTableID.setText(Tisch.ausgewaehlterTisch);
        tableViewAnzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableViewArtikel.setCellValueFactory(new PropertyValueFactory<>("artikel"));
        tableViewPreis.setCellValueFactory(new PropertyValueFactory<>("preis"));

        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                tisch.showTableView(rechnungAnzeigeTafel);
                tisch.umsatzBerechnung(umsatzID);
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
    private void alsPDFSpeichern() throws IOException, DocumentException {
        double steuerSpeisen = 0;
        double steuerGetraenke = 0;
        Document pdfdoc= new Document();
        //pdfdoc.addPage(new PDPage());
        PdfWriter writer = PdfWriter.getInstance(pdfdoc, new FileOutputStream("C:\\Users\\public\\Rechnungsnummer" + Rechnungsnummer + ".pdf"));
        pdfdoc.open();
        pdfdoc.add(new Paragraph("you have to pay " + umsatzID.getText() ));
        pdfdoc.add(new Paragraph("Now it is " + datumZeit.getText() ));
        int i = 0;
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                    for(Entry entry: tisch.data){
                        pdfdoc.add(new Paragraph("" + entry.anzahl + "x, " + entry.artikel +", inkl. " + entry.USTGB*100 +"% steuer"));
                    }
                    steuerGetraenke = tisch.berechnungGetraenkeSteuer();
                    steuerSpeisen = tisch.berechnungSpeisenSteuer();
                    tisch.data.clear();
                }
            }
        pdfdoc.add(new Paragraph("Speisensteuer...." + steuerSpeisen ));
        pdfdoc.add(new Paragraph("getraenkesteuer.... " + steuerGetraenke ));

        //pdfdoc.save("C:\\Users\\public\\Sample.pdf");
        System.out.println("PDF created");
        Rechnungsnummer++;
        System.out.println(Rechnungsnummer);
        pdfdoc.close();
    }
}
