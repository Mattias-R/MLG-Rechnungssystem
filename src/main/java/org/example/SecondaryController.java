package org.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;


public class SecondaryController {
    Scene scene = App.getScene();
    GridPane designerMattias;
    Button peter = new Button("hallo");

    public void test1 (){
        designerMattias = (GridPane) scene.lookup("#gridpanetable");
        designerMattias.add(peter,4,4);
        System.out.println("hallo");
    }


    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");

    }


    public void test2(ActionEvent actionEvent) {
    designerMattias.getChildren().remove(peter);

    }
}