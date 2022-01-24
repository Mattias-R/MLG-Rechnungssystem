package org.klassen;

import java.util.ArrayList;

public class Mitarbeiter extends Person{

    public int mitarbeiternummer;
    public ArrayList<Rechnung> rechnungsliste;
    public double tagesumsatz;
    private String pin;
    public static ArrayList<Mitarbeiter> mitarbeiterList = new ArrayList<>();

    public Mitarbeiter(int mitarbeiternummer, String name, String pin) {
        this.name = name;
        this.pin = pin;
        this.mitarbeiternummer = mitarbeiternummer;
    }

    @Override
    public void abrechnung() {
    }

    public static void createMitarbeiterList(String mitarbeiterString){
        mitarbeiterString.replace(",",".");
        String[] mitarbeiterArray = mitarbeiterString.split(";");
        Mitarbeiter mitarbeiter = new Mitarbeiter(Integer.parseInt(mitarbeiterArray[0]), mitarbeiterArray[1].replace("."," "), mitarbeiterArray[2].replace("."," "));
        mitarbeiterList.add(mitarbeiter);
    }

    public String getPin() {
        return pin;
    }
}
