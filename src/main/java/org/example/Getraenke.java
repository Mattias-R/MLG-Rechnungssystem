package org.example;

public class Getraenke extends Artikel {

    public double volumen;
    public boolean alkoholisch;

    public Getraenke(String name,  int preis, double volumen, boolean alkoholisch) {
        this.name = name;
        this.preis = preis;
        this.volumen = volumen;
        this.alkoholisch = alkoholisch;
    }
}
