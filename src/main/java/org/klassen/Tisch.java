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

    public void speiseHinzufuegen(Speisen speise, int anzahl) {
        if(konsumation.contains(speise)){
                int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(speise)) + anzahl;
                konsumationAnzahl.set(konsumation.indexOf(speise), neueAnzahl);
        } else {
                konsumation.add(speise);
                konsumationAnzahl.add(anzahl);
        }
    }

    public void getraenkHinzufuegen(Getraenke getraenk, int anzahl) {
        if(konsumation.contains(getraenk)){
            int neueAnzahl = konsumationAnzahl.get(konsumation.indexOf(getraenk)) + anzahl;
            konsumationAnzahl.set(konsumation.indexOf(getraenk), neueAnzahl);
        } else {
            konsumation.add(getraenk);
            konsumationAnzahl.add(anzahl);
        }
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
    public Artikel showKonsumation(){
        int i = 0;
        for(Artikel x : konsumation){
            System.out.println(konsumationAnzahl.get(i) + " x " +x.name + " " + x.preis);
            i++;
        }
        return null;
    }

}
