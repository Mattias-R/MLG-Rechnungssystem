package org.klassen;

import java.util.ArrayList;

public class Mitarbeiter extends Person{

    public int mitarbeiternummer;
    public ArrayList<Rechnung> rechnungsliste;
    public double tagesumsatz;

    public Mitarbeiter(String name, int mitarbeiternummer) {
        this.name = name;
        this.mitarbeiternummer = mitarbeiternummer;
    }

    @Override
    public void abrechnung() {
    }


}
