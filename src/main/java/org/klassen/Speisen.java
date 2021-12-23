package org.klassen;

import org.controller.App;

import java.util.ArrayList;

public class Speisen extends Artikel {

    //public String beilage;
    final public static int umsatzsteuer = 10;
    public static ArrayList speisenListe = new ArrayList();

    public Speisen(String name, double preis/*, String beilage*/) {
        this.name = name;
        this.preis = preis;
        //this.beilage = beilage;
    }

    public static void createSpeisenList(){
        ArrayList neu = App.hauptspeisenListe;


        for(int i = 0; i < speisenListe.size(); i++){
            System.out.println(speisenListe.get(i));
        }
    }

}
