package com.example.moviebookingsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Navigator {
    public void Navigate(String URL,String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(URL));
        Scene scene = new Scene(fxmlLoader.load(), 1544, 903);
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
