package com.example.moviebookingsystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UsersMenu implements Initializable {
    @FXML
    Pane maxPane,homePane,goldPane;
    @FXML
    ComboBox <String> waysToWatch;
    @FXML
    String ways_towatch [] = { "MAX", "GOLD"};
    ObservableList<String> items = FXCollections.observableArrayList("MAX","GOLD");
    @FXML
    public void onGoToFood() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("Meals.fxml","Meals");
    }
    @FXML
    public void onClick(){
        if(waysToWatch.getValue() == "MAX")
            maxPane.toFront();
        if(waysToWatch.getValue() == "GOLD")
            goldPane.toFront();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        waysToWatch.setItems(items);
    }
    @FXML
    public void goBack(){
        homePane.toFront();
        waysToWatch.setValue(null);
        waysToWatch.setPromptText("Ways To Watch");
    }
    public void goBackGold(){
        homePane.toFront();
        waysToWatch.setValue(null);
    }
}




