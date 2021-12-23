package org.klassen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Tisch {

    public static String ausgewaehlterTisch = "";
    public int tischnummer;
    public ArrayList<Artikel> konsumation;
    public static Set<Tisch> tischListe = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(tischnummer);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tisch tisch = (Tisch) o;
        return tischnummer == tisch.tischnummer;
    }

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

    public static void testtisch(){
       for(Tisch n:tischListe){
           System.out.println(n.tischnummer);
       }
    }

}
