package org.klassen;

import org.controller.SpeisenController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Tisch {

    public static String ausgewaehlterTisch = "";
    public int tischnummer;
    public ArrayList<Artikel> konsumation = new ArrayList<>();
    public ArrayList<Integer> konsumationAnzahl = new ArrayList<>();
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

    public void artikelHinzufuegen(Artikel artikel, int anzahl) {
        if(konsumation.contains(artikel)){
            int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(artikel)) + anzahl;
            konsumationAnzahl.set(konsumation.indexOf(artikel), neueAnzahl);
        } else {
            konsumation.add(artikel);
            konsumationAnzahl.add(anzahl);
        }
    }

    public void artikelLoeschen(Artikel artikel, int anzahl) {
        if(konsumation.contains(artikel) && konsumationAnzahl.get(konsumation.indexOf(artikel)) <= anzahl){
            konsumationAnzahl.remove(konsumationAnzahl.get(konsumation.indexOf(artikel)));
            konsumation.remove(artikel);
        } else {
            int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(artikel)) - anzahl;
            konsumationAnzahl.set(konsumation.indexOf(artikel), neueAnzahl);
        }
    }

    public void mitarbeiterRabatt() {
    }

    public static void testtisch(){
       for(Tisch n:tischListe){
           System.out.println(n.tischnummer);
       }
    }
    public Artikel showKonsumation(){
        int i = 0;
        for(Artikel x : konsumation){
            System.out.println(konsumationAnzahl.get(i) + " x " +x.name + " " + x.preis);
            i++;
        }
        return null;
    }

}
