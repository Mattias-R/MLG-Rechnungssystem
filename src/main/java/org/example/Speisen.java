package org.example;

public class Speisen extends Artikel {

    public String beilage;

    public Speisen(String name, int preis, String beilage) {
        this.name = name;
        this.preis = preis;
        this.beilage = beilage;
    }

}
