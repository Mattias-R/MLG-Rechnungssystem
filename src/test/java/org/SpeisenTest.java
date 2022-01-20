package org;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.klassen.Entry;
import org.klassen.Getraenke;
import org.klassen.Speisen;
import org.klassen.Tisch;

import javax.swing.text.TableView;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SpeisenTest {

    @Test
    public void SpeisenListTest1(){
        Speisen.createSpeisenList("Gebackener.Emmentaler;10,90");
        assertEquals(Speisen.speisenListe.get(0).name, "Gebackener Emmentaler");
        Speisen.speisenListe.clear();
    }
    @Test
    public void SpeisenListTest2(){
        Speisen.createSpeisenList("Backhendlsalat;11,90");
        assertEquals(Speisen.speisenListe.get(0).name, "Backhendlsalat");
        Speisen.speisenListe.clear();
    }
    @Test
    public void SpeisenListTest3(){
        Speisen.createSpeisenList("Tiramisu;4,90");
        assertEquals(Speisen.speisenListe.get(0).name, "Tiramisu");
        Speisen.speisenListe.clear();
    }
    @Test
    public void SpeisenListPreisTest1(){
        Speisen.createSpeisenList("Gebackener.Emmentaler;10,90");
        assertEquals(Speisen.speisenListe.get(0).preis, 10.90);
        Speisen.speisenListe.clear();
    }
    @Test
    public void SpeisenListPreisTest2(){
        Speisen.createSpeisenList("Backhendlsalat;11,90");
        assertEquals(Speisen.speisenListe.get(0).preis, 11.90);
        Speisen.speisenListe.clear();
    }
    @Test
    public void SpeisenListPreisTest3(){
        Speisen.createSpeisenList("Tiramisu;4,90");
        assertEquals(Speisen.speisenListe.get(0).preis, 4.90);
        Speisen.speisenListe.clear();
    }
}
