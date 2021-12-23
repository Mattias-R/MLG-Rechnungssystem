package org.klassen;

import java.util.ArrayList;

public class Getraenke extends Artikel {

    public boolean alkoholisch;
    final public static int umsatzsteuer = 20;
    public static ArrayList<Getraenke> getraenkeList = new ArrayList<>();

    public Getraenke(String name,  double preis, boolean alkoholisch) {
        this.name = name;
        this.preis = preis;
        this.alkoholisch = alkoholisch;
    }

    public static void createGetraenkeList(String getraenkeString){
        /*for(int i = 0; i < App.hauptspeisenListe.size(); i++){
            int param = App.hauptspeisenListe.get(i).toString().indexOf(";");
            String name = App.hauptspeisenListe.get(i).toString().replace(".", " ").substring(0, param);
            Double preis = Double.parseDouble(App.hauptspeisenListe.get(i).toString().replace(".", " ").replace(",",".").substring(param+1));
            Speisen neu = new Speisen(name, preis);
            speisenListe.add(neu);
        }*/

        getraenkeString.replace(",",".");
        String[] getraenkeArray = getraenkeString.split(";");
        Getraenke getraenk = new Getraenke(getraenkeArray[0].replace("."," "), Double.parseDouble(getraenkeArray[1].replace(",",".")), Boolean.parseBoolean(getraenkeArray[2]));
        getraenkeList.add(getraenk);
    }

    public static void printGetraenkeListe() {
        for(int i = 0; i < getraenkeList.size(); i++) {
            System.out.println(getraenkeList.get(i).name);
        }
    }
}
