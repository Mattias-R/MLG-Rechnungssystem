package org.klassen;

public class Speisen extends Artikel {

    public String beilage;
    final public static int umsatzsteuer = 10;

    public Speisen(String name, int preis, String beilage) {
        this.name = name;
        this.preis = preis;
        this.beilage = beilage;
    }

}
