package org.example;

public class Getraenke extends Artikel {

    public double volumen;
    public boolean alkoholisch;
    final public static int umsatzsteuer = 20;

    public Getraenke(String name,  int preis, double volumen, boolean alkoholisch) {
        this.name = name;
        this.preis = preis;
        this.volumen = volumen;
        this.alkoholisch = alkoholisch;
    }
}
