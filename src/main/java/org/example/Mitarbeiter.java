package org.example;

import java.util.ArrayList;

public class Mitarbeiter extends Person{

    public int mitarbeitenumer;
    public ArrayList rechnungsliste;
    public double tagesumsatz;

    public Mitarbeiter(String name, int mitarbeitenumer) {
        name = this.name;
        mitarbeitenumer = this.mitarbeitenumer;
    }

    @Override
    public void Abrechnung() {
    }


}
