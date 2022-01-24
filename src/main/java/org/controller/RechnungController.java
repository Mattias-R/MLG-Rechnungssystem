package org.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.klassen.Entry;
import org.klassen.Rechnung;
import org.klassen.Tisch;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
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
    private void abfrage(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Wollen Sie eine Rechnung erstellen?","Warnung",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                alsPDFSpeichern();
            }catch (Exception e){

            }
        }
    }


    private void alsPDFSpeichern() throws IOException, DocumentException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Rechnungsnummer = Integer.parseInt(reader.readLine());
        double steuerSpeisen = 0;
        double steuerGetraenke = 0;
        Document pdfdoc= new Document();
        PdfWriter writer = PdfWriter.getInstance(pdfdoc, new FileOutputStream("C:\\Users\\public\\Rechnungsnummer" + Rechnungsnummer + ".pdf"));
        pdfdoc.open();
        //styling for the pdf
        Paragraph paragraph1 = new Paragraph();
        Paragraph paragraph2 = new Paragraph();
        paragraph1.setAlignment(Element.ALIGN_RIGHT);
        paragraph2.setAlignment(Element.ALIGN_CENTER);
        paragraph2.setSpacingAfter(5);
        paragraph2.setIndentationLeft(20);
        paragraph2.setIndentationRight(20);
        paragraph2.setTabSettings(new TabSettings(56f));
        //text of the pdf starts here
        paragraph1.add(new Paragraph("Datum: " + datumZeit.getText() ));
        pdfdoc.add(paragraph1);
        Font f=new Font(Font.FontFamily.HELVETICA,40.0f, Font.UNDERLINE, BaseColor.LIGHT_GRAY);
        pdfdoc.add(new Paragraph("Rechnungsnummer " + Rechnungsnummer,f));
        pdfdoc.add(Chunk.TABBING);
        pdfdoc.add(Chunk.TABBING);
        for (Tisch tisch : Tisch.tischListe) {
            if (tisch.tischnummer == Integer.parseInt(Tisch.ausgewaehlterTisch)) {
                    for(Entry entry: Rechnung.rechnung){
                        paragraph2.add(new Paragraph("" + entry.anzahl + "x, " + entry.artikel +" "+ entry.preis +"€   "+ " inkl. " + entry.USTGB*100 +"% steuer"));
                    }
                    steuerGetraenke = tisch.berechnungGetraenkeSteuer();
                    steuerSpeisen = tisch.berechnungSpeisenSteuer();
                    tisch.data.clear();
                    Rechnung.rechnung.clear();
                pdfdoc.add(paragraph2);
                }
            }
        pdfdoc.add(Chunk.TABBING);
        pdfdoc.add(new Paragraph("Summe:" + umsatzID.getText() + "€" ));
        pdfdoc.add(Chunk.TABBING);
        pdfdoc.add(new Paragraph("Speisensteuer...." + steuerSpeisen + "€"));
        pdfdoc.add(new Paragraph("getraenkesteuer.... " + steuerGetraenke + "€"));
        System.out.println("PDF created");
        Rechnungsnummer++;
        file.createNewFile();
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        fileWriter.write("" + Rechnungsnummer);
        fileWriter.close();
        reader.close();
        pdfdoc.close();
        App.setRoot("tisch");
    }
}
