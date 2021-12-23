package org.klassen;

import org.controller.App;

import java.util.ArrayList;

public class Speisen extends Artikel {

    //public String beilage;
    final public static int umsatzsteuer = 10;
    public static ArrayList<Speisen> speisenListe = new ArrayList();

    public Speisen(String name, double preis/*, String beilage*/) {
        this.name = name;
        this.preis = preis;
        //this.beilage = beilage;
    }

    public static void createSpeisenList(){
        for(int i = 0; i < App.hauptspeisenListe.size(); i++){
            int param = App.hauptspeisenListe.get(i).toString().indexOf(";");
            String name = App.hauptspeisenListe.get(i).toString().replace(".", " ").substring(0, param);
            Double preis = Double.parseDouble(App.hauptspeisenListe.get(i).toString().replace(".", " ").replace(",",".").substring(param+1));
            Speisen neu = new Speisen(name, preis);
            speisenListe.add(neu);
        }
    }
    public static void showSpeisenList(){
        for(int i = 0; i < speisenListe.size(); i++){
            System.out.println(speisenListe.get(i).name);
        }
    }

}
