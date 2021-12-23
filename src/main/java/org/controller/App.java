package org.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.klassen.Getraenke;
import org.klassen.Speisen;
import org.klassen.Tisch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {
    public static ArrayList hauptspeisenListe = new ArrayList();
    public static ArrayList vorspeisenListe = new ArrayList();
    public static ArrayList nachspeisenListe = new ArrayList();
    public static ArrayList alkoholfreiListe = new ArrayList();
    public static ArrayList alkoholListe = new ArrayList();
    public static ArrayList kaffeeListe = new ArrayList();
    private static Scene scene;

    // set minimum window to 1440x1080
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1440, 1080);
        stage.setMaximized(true);
        stage.setMinHeight(1080);
        stage.setMinWidth(1440);
        stage.setScene(scene);
        loadFood();
        stage.show();

    }

    public static Scene getScene() {
        return scene;
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void loadFood(){
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Hauptspeisen.txt"))) {
            while (scanner.hasNext()){
                String speise = scanner.next();
                hauptspeisenListe.add(speise);
                //System.out.println(scanner.next());
                Speisen.createSpeisenList(speise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vorspeisenListe);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Vorspeisen.txt"))) {
            while (scanner.hasNext()){
                String speise = scanner.next();
                vorspeisenListe.add(speise);
                //System.out.println(scanner.next());
                Speisen.createSpeisenList(speise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vorspeisenListe);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Nachspeisen.txt"))) {
            while (scanner.hasNext()){
                String speise = scanner.next();
                nachspeisenListe.add(speise);
                //System.out.println(scanner.next());
                Speisen.createSpeisenList(speise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(nachspeisenListe);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Alkoholfrei.txt"))) {
            while (scanner.hasNext()){
                String getraenk = scanner.next();
                alkoholfreiListe.add(getraenk);
                //System.out.println(scanner.next());
                Getraenke.createGetraenkeList(getraenk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(alkoholListe);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Alkoholisch.txt"))) {
            while (scanner.hasNext()){
                String getraenk = scanner.next();
                alkoholListe.add(getraenk);
                //System.out.println(scanner.next());
                Getraenke.createGetraenkeList(getraenk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(alkoholfreiListe);
        try (Scanner scanner = new Scanner(new File("src/main/resources/org.textfiles/Kaffee.txt"))) {
            while (scanner.hasNext()){
                String getraenk = scanner.next();
                kaffeeListe.add(getraenk);
                Getraenke.createGetraenkeList(getraenk);
                //System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(kaffeeListe);
        System.out.println(Speisen.speisenListe);
    }

}