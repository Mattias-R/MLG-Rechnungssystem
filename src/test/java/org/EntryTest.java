package org;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.klassen.Entry;
import org.klassen.Tisch;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryTest {

    @Test
    public void saveEntryToTischData1(){
        Entry newEntry = new Entry(5, "Schweinsbraten", 5, 20);
        Tisch tisch = new Tisch(1);
        tisch.data.add(newEntry);
        assertEquals(newEntry.artikel, tisch.data.get(0).artikel);
    }
    @Test
    public void saveEntryToTischData2(){
        Entry newEntry = new Entry(5, "Schweinsbraten", 5, 20);
        Tisch tisch = new Tisch(1);
        tisch.data.add(newEntry);
        assertEquals(newEntry.anzahl, tisch.data.get(0).anzahl);
    }
    @Test
    public void saveEntryToTischData3(){
        Entry newEntry = new Entry(5, "Schweinsbraten", 5, 20);
        Tisch tisch = new Tisch(1);
        tisch.data.add(newEntry);
        assertEquals(newEntry.USTGB, tisch.data.get(0).USTGB);
    }


}
