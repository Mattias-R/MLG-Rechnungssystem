package org.example;

import java.util.ArrayList;

public class Chef extends Person{

    public static ArrayList mitarbeiterliste;

    @Override
    public void abrechnung() {
    }

    public void mitarbeiterAnlegen(String name, int mitarbeiternummer) {
        Mitarbeiter neuerMitarbeiter = new Mitarbeiter(name, mitarbeiternummer);

        mitarbeiterliste.add(neuerMitarbeiter);
    }
}
