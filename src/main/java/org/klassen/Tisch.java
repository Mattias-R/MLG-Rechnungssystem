package org.klassen;

import java.util.ArrayList;

public class Tisch {

    public static String ausgewaehlterTisch = "";
    public int tischnummer;
    public ArrayList<Artikel> konsumation;

    public Tisch(int nummer) {
        tischnummer = nummer;
    }

    public void speiseHinzufuegen(Speisen speise) {
        konsumation.add(speise);
    }

    public void getraenkHinzufuegen(Getraenke getraenk) {
        konsumation.add(getraenk);
    }

    public void loeschen(Artikel artikel) {
            konsumation.remove(artikel);
    }

    public void mitarbeiterRabatt() {
    }

}
