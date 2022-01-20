package org;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.klassen.Entry;
import org.klassen.Tisch;

import javax.swing.text.TableView;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TischTest {

    @Test
    public void USTGBTest1Getraenke(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Getraenk", 5, 0.2);
        Entry newEntry2 = new Entry(5, "Getraenk", 8, 0.2);
        Entry newEntry3 = new Entry(5, "Getraenk", 16, 0.2);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungGetraenkeSteuer();
        assertEquals(x, 29.0);
    }
    @Test
    public void USTGBTest2Getraenke(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Getraenk", 22, 0.2);
        Entry newEntry2 = new Entry(5, "Getraenk", 23, 0.2);
        Entry newEntry3 = new Entry(5, "Getraenk", 99, 0.2);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungGetraenkeSteuer();
        assertEquals(x, 144.0);
    }
    @Test
    public void USTGBTest3Getraenke(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Getraenk", 5.6, 0.2);
        Entry newEntry2 = new Entry(5, "Getraenk", 8.2, 0.2);
        Entry newEntry3 = new Entry(5, "Getraenk", 16.8, 0.2);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungGetraenkeSteuer();
        assertEquals(x, 30.6);
    }

    @Test
    public void USTGBTest1Speisen(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Speisen", 5.6, 0.1);
        Entry newEntry2 = new Entry(5, "Speisen", 8.2, 0.1);
        Entry newEntry3 = new Entry(5, "Speisen", 16.8, 0.1);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungSpeisenSteuer();
        assertEquals(x, 15.3);
    }
    @Test
    public void USTGBTest2Speisen(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Speisen", 8, 0.1);
        Entry newEntry2 = new Entry(5, "Speisen", 9, 0.1);
        Entry newEntry3 = new Entry(5, "Speisen", 22, 0.1);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungSpeisenSteuer();
        assertEquals(x, 19.5);
    }
    @Test
    public void USTGBTest3Speisen(){
        Tisch tisch = new Tisch(1);
        Entry newEntry = new Entry(5, "Speisen", 11, 0.1);
        Entry newEntry2 = new Entry(5, "Speisen", 22, 0.1);
        Entry newEntry3 = new Entry(5, "Speisen", 55, 0.1);
        tisch.data.add(newEntry);
        tisch.data.add(newEntry2);
        tisch.data.add(newEntry3);
        double x = tisch.berechnungSpeisenSteuer();
        assertEquals(x, 44);
    }




}
