package org.klassen;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.controller.SpeisenController;

import java.security.KeyStore;
import java.util.*;

public class Tisch {

    public static String ausgewaehlterTisch = "";
    public int tischnummer;
    public ArrayList<Artikel> konsumation = new ArrayList<>();
    public ArrayList<Integer> konsumationAnzahl = new ArrayList<>();
    public static Set<Tisch> tischListe = new HashSet<>();
    public ObservableList<Entry> data = FXCollections.observableArrayList();

    @Override
    public int hashCode() {
        return Objects.hash(tischnummer);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tisch tisch = (Tisch) o;
        return tischnummer == tisch.tischnummer;
    }

    public Tisch(int nummer) {
        tischnummer = nummer;
    }

    public void artikelHinzufuegen(Artikel artikel, int anzahl) {
        if(konsumation.contains(artikel)){
            int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(artikel)) + anzahl;
            konsumationAnzahl.set(konsumation.indexOf(artikel), neueAnzahl);
        } else {
            konsumation.add(artikel);
            konsumationAnzahl.add(anzahl);
        }
    }

    public void artikelLoeschen(Artikel artikel, int anzahl) {
        if(konsumation.contains(artikel) && konsumationAnzahl.get(konsumation.indexOf(artikel)) <= anzahl){
            konsumationAnzahl.remove(konsumationAnzahl.get(konsumation.indexOf(artikel)));
            konsumation.remove(artikel);
        } else {
            int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(artikel)) - anzahl;
            konsumationAnzahl.set(konsumation.indexOf(artikel), neueAnzahl);
        }
    }

    public void mitarbeiterRabatt() {
    }

    public static void teest(Observable data, Artikel artikel, int anzahl){
        //SpeisenController.data.add(new Entry("test","test","test"));
    }

    public void addToTableView(TableView x, Artikel artikel, int anzahl, double USTGB) {
        //x.setItems(data);
        this.data.add(new Entry(anzahl, artikel.name, artikel.preis, USTGB));
        //this.umsatz.add(new Entry(anzahl, artikel.name, artikel.preis, USTGB));
        //tableAnzahl.setText("" + anzahl);
        //tableArtikel.setText(artikel.name);
        //tablePreis.setText("" + artikel.preis);
        //Entry newEntry = new Entry("" + anzahl, artikel.name, "" + artikel.preis);
        //tableView.getColumns().addAll(tableAnzahl, tableArtikel, tablePreis);
        //tableView.getItems().add(new Entry("test","test","test"));
        //tableView.setItems(SpeisenController.data);
        //SpeisenController.data.add(new Entry("test","test","test"));
        //data.add(newEntry);
        //tableView.setItems(data);
    }
    public void showTableView(TableView x){
        x.setItems(data);
    }

    public Artikel showKonsumation(){
        int i = 0;
        for(Artikel x : konsumation){
            //System.out.println(konsumationAnzahl.get(i) + " x " +x.name + " " + x.preis);
            i++;
        }
        return null;
    }
    public void umsatzBerechnung(TextField textfield){
        double x = 0;
        for(Entry entry: data){
            x += (entry.preis * entry.USTGB) * entry.anzahl;
        }
        //double y = Math.round(x*10)/10;
        String ums = "" + x;
        textfield.setText(ums);
        System.out.printf("%.2f %n", x);
        //System.out.println(y);
    }


}

