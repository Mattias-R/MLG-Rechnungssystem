package org.klassen;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Entry {
    public int anzahl;
    public String artikel;
    public double preis;
    public double USTGB;

    public Entry(int anzahl, String artikel, double preis, double USTGB){
        this.anzahl = anzahl;
        this.artikel = artikel;
        this.preis = preis;
        this.USTGB = USTGB;
    }

    //without getter the observarble list doesnt work
    public int getAnzahl() {
        return anzahl;
    }

    public String getArtikel() {
        return artikel;
    }

    public double getPreis() {
        return preis;
    }
    public static void addItemToList(ObservableList data, int anzahl, String artikel, double preis, double USTGB){
        data.add(new Entry(anzahl, artikel, preis, USTGB));
    }


}
