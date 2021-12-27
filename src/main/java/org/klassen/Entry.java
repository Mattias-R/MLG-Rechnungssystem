package org.klassen;

import javafx.collections.ObservableList;

public class Entry {
    public String anzahl;
    public String artikel;
    public String preis;

    public Entry(String anzahl, String artikel, String preis){
        this.anzahl = anzahl;
        this.artikel = artikel;
        this.preis = preis;
    }

    public static void createEntryInList(ObservableList data, String anzahl, String preis, String artikel){

    }
}
