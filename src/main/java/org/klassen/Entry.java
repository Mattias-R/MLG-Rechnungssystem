package org.klassen;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(artikel);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return artikel == entry.artikel;
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
