package org.klassen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Rechnung {

    public int summe;
    public int rechnungsnummer;
    public String datum;
    public static ObservableList<Entry> rechnung = FXCollections.observableArrayList();

    public void rechnungErstellen(Tisch tisch) {
    }

    public static void zusammenFuegen(Tisch tisch, TableView tableView){
        for(Entry entry : tisch.data){
            if(rechnung.contains(entry)){
                rechnung.get(rechnung.indexOf(entry)).anzahl += entry.anzahl;
            } else {
                rechnung.add(entry);
            }
        }

        tableView.setItems(rechnung);

        for(Entry entry : rechnung){
            System.out.println(entry);
        }
    }
}
