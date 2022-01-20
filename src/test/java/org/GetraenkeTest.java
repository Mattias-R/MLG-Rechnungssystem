package org;
import javafx.collections.ObservableList;
import org.junit.Test;
import org.klassen.Entry;
import org.klassen.Getraenke;
import org.klassen.Tisch;

import javax.swing.text.TableView;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class GetraenkeTest {

    @Test
    public void GetraenkeListTest1(){
        Getraenke.createGetraenkeList("0,25.Weißer.Spritzer;2,90;true");
        assertEquals(Getraenke.getraenkeList.get(0).name, "0,25 Weißer Spritzer");
        Getraenke.getraenkeList.clear();
    }
    @Test
    public void GetraenkeListTest2(){
        Getraenke.createGetraenkeList("0,5.Roter.Spritzer;4,90;true");
        assertEquals(Getraenke.getraenkeList.get(0).name, "0,5 Roter Spritzer");
        Getraenke.getraenkeList.clear();
    }
    @Test
    public void GetraenkeListTest3(){
        Getraenke.createGetraenkeList("0,75.Mineral.Prickelnd;4,90;false");
        assertEquals(Getraenke.getraenkeList.get(0).name, "0,75 Mineral Prickelnd");
        Getraenke.getraenkeList.clear();
    }

    @Test
    public void GetraenkeListPreisTest1(){
        Getraenke.createGetraenkeList("0,25.Weißer.Spritzer;2,90;true");
        assertEquals(Getraenke.getraenkeList.get(0).preis, 2.90);
        Getraenke.getraenkeList.clear();
    }
    @Test
    public void GetraenkeListPreisTest2(){
        Getraenke.createGetraenkeList("0,5.Roter.Spritzer;4,90;true");
        assertEquals(Getraenke.getraenkeList.get(0).preis, 4.90);
        Getraenke.getraenkeList.clear();
    }
    @Test
    public void GetraenkeListPreisTest3(){
        Getraenke.createGetraenkeList("0,75.Mineral.Prickelnd;4,90;false");
        assertEquals(Getraenke.getraenkeList.get(0).preis, 4.90);
        Getraenke.getraenkeList.clear();
    }
}
