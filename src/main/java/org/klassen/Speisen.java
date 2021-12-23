package org.klassen;

import org.controller.App;
import org.controller.SpeisenController;
import org.controller.TischController;

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

    public static void createSpeisenList(String speisenString){
        /*for(int i = 0; i < App.hauptspeisenListe.size(); i++){
            int param = App.hauptspeisenListe.get(i).toString().indexOf(";");
            String name = App.hauptspeisenListe.get(i).toString().replace(".", " ").substring(0, param);
            Double preis = Double.parseDouble(App.hauptspeisenListe.get(i).toString().replace(".", " ").replace(",",".").substring(param+1));
            Speisen neu = new Speisen(name, preis);
            speisenListe.add(neu);
        }*/
        speisenString.replace(",",".");
        String[] speisenArray = speisenString.split(";");
        Speisen speise = new Speisen(speisenArray[0].replace("."," "), Double.parseDouble(speisenArray[1].replace(",",".")));
        speisenListe.add(speise);
    }
    public static void showSpeisenList(){
        for(int i = 0; i < speisenListe.size(); i++){
            System.out.println(speisenListe.get(i).name);
        }
    }

    public static void speisenZuRechnunghinzufuegen(){
        SpeisenController test = new SpeisenController();
        if(test.speisenEingabe.getText() != null){
            for (int i = 0; i < speisenListe.size(); i++){
                if (test.speisenEingabe.getText() == speisenListe.get(i).name){
                    //speichere in Tableliste
                }
            }
        }else {
                //Pop up ist noch keine speise ausgewaehlt
        }
    }


}
