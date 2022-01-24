package org.klassen;

import java.util.ArrayList;

public class Chef extends Person{

    public static ArrayList<Mitarbeiter> mitarbeiterliste;

    private static Chef instance = null;

    public static Chef getInstance(String name) {
        if(instance == null) {
            return new Chef(name);
        } else return instance;
    }

    private Chef(String name) {
        this.name = name;
    }

    @Override
    public void abrechnung() {
    }

    public void mitarbeiterAnlegen(String name, int mitarbeiternummer) {
        Mitarbeiter neuerMitarbeiter = new Mitarbeiter(mitarbeiternummer, name, "xxxxx");

        mitarbeiterliste.add(neuerMitarbeiter);
    }
}
