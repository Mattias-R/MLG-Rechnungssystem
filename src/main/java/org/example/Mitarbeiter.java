package org.example;

import java.util.ArrayList;

public class Mitarbeiter extends Person{

    public int mitarbeiternummer;
    public ArrayList rechnungsliste;
    public double tagesumsatz;

    public Mitarbeiter(String name, int mitarbeiternummer) {
        name = this.name;
        mitarbeiternummer = this.mitarbeiternummer;
    }

    @Override
    public void abrechnung() {
    }


}
