package org.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.klassen.Entry;
import org.klassen.Rechnung;
import org.klassen.Tisch;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.io.IOException;


public class RechnungController {
    public TextField rechnungTableID;
    public TextField datumZeit;
    public TableView rechnungAnzeigeTafel;
    public TableColumn<ObservableList<Entry>, String> tableViewAnzahl;
    public TableColumn<ObservableList<Entry>, String> tableViewArtikel;
    public TableColumn<ObservableList<Entry>, String> tableViewPreis;
    public static File file = new File("src/main/resources/org.textfiles/Rechnungsnummer.txt");
    public static int Rechnungsnummer;
    public TextField umsatzID;


    public void initialize(){
        App.initClock(datumZeit);

        rechnungTableID.setText(Tisch.ausgewaehlterTisch);
        tableViewAnzahl.setCellValueFactory(new PropertyValueFactory<>("anzahl"));
        tableViewArtikel.setCellValueFactory(new PropertyValueFactory<>("artikel"));
        tableViewPreis.setCellValueFactory(new PropertyValueFactory<>("preis"));

        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                //tisch.showTableView(rechnungAnzeigeTafel);
                Rechnung.zusammenFuegen(tisch, rechnungAnzeigeTafel);
                tisch.umsatzBerechnung(umsatzID);
            }
        }
    }

    @FXML
    public void switchToSpeisen() throws IOException {
        Rechnung.rechnung.clear();
        App.setRoot("speisen");
    }
    @FXML
    public void switchToGetraenke() throws IOException{
        Rechnung.rechnung.clear();
        App.setRoot("getraenke");
    }
    @FXML
    private void switchToSecondary() throws IOException {
        Rechnung.rechnung.clear();
        App.setRoot("tisch");
    }
    @FXML
    private void alsPDFSpeichern() throws IOException, DocumentException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Rechnungsnummer = Integer.parseInt(reader.readLine());
        double steuerSpeisen = 0;
        double steuerGetraenke = 0;
        Document pdfdoc= new Document();
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
        System.out.println("PDF created");
        Rechnungsnummer++;
        file.createNewFile();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        fileWriter.write("" + Rechnungsnummer);

        fileWriter.close();
        reader.close();
        pdfdoc.close();
    }
}
