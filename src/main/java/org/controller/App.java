package org.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.klassen.Getraenke;
import org.klassen.Speisen;
import org.klassen.Tisch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {
    public static ArrayList<String> hauptspeisenListe = new ArrayList();
    public static ArrayList<String> vorspeisenListe = new ArrayList();
    public static ArrayList<String> nachspeisenListe = new ArrayList();
    public static ArrayList<String> alkoholfreiListe = new ArrayList();
    public static ArrayList<String> alkoholListe = new ArrayList();
    public static ArrayList<String> kaffeeListe = new ArrayList();
    private static Scene scene;

    // set minimum window to 1440x1080
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("tisch"), 1440, 1080);
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

        addSpeisenFromScanner("src/main/resources/org.textfiles/Hauptspeisen.txt", hauptspeisenListe);
        addSpeisenFromScanner("src/main/resources/org.textfiles/Vorspeisen.txt", vorspeisenListe);
        addSpeisenFromScanner("src/main/resources/org.textfiles/Nachspeisen.txt", nachspeisenListe);
        addGetraenkeFromScanner("src/main/resources/org.textfiles/Alkoholfrei.txt",alkoholfreiListe);
        addGetraenkeFromScanner("src/main/resources/org.textfiles/Alkoholisch.txt",alkoholListe);
        addGetraenkeFromScanner("src/main/resources/org.textfiles/Kaffee.txt",kaffeeListe);

        /*
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
        //System.out.println(vorspeisenListe);
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
        //System.out.println(vorspeisenListe);
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
        //System.out.println(nachspeisenListe);
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
        //System.out.println(alkoholListe);
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
        //System.out.println(alkoholfreiListe);
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
        //System.out.println(kaffeeListe);
        //System.out.println(Speisen.speisenListe);
        */

    }

    public static void initClock(TextField textField) {
        Timeline clock = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            textField.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    public static void addGetraenkeFromScanner(String path, ArrayList list){
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()){
                String getraenk = scanner.next();
                list.add(getraenk);
                Getraenke.createGetraenkeList(getraenk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void addSpeisenFromScanner(String path, ArrayList list){
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()){
                String speise = scanner.next();
                list.add(speise);
                //System.out.println(scanner.next());
                Speisen.createSpeisenList(speise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}