package org.klassen;

import javafx.collections.ObservableList;

public class Entry {
    public int anzahl;
    public String artikel;
    public double preis;

    public Entry(int anzahl, String artikel, double preis){
        this.anzahl = anzahl;
        this.artikel = artikel;
        this.preis = preis;
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
    public static void addItemToList(ObservableList data, int anzahl, String artikel, double preis){
        data.add(new Entry(anzahl, artikel, preis));
    }


}
