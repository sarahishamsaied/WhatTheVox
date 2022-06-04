package com.example.moviebookingsystem;

import Classes.Meal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Meals implements Initializable {
    @FXML
    FlowPane flowPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Meal> meals = new ArrayList<Meal>(100);
        for (int i = 0 ; i<5;i++){
            Random random = new Random();
            Meal meal = new Meal(String.valueOf(random.nextInt()),String.valueOf(random.nextInt()),String.valueOf(random.nextInt()),random.nextDouble(),random.nextInt());
            meals.add(meal);
        }
        for (Meal meal : meals){
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(40,40,40,40));
            Label title = new Label(meal.getMealTitle());
            title.setTextFill(Color.WHITE);
            Label price = new Label(String.valueOf(meal.getPrice()));
            price.setTextFill(Color.WHITE);
            ImageView imageView = new ImageView();
            Image image = new Image("https://i5.walmartimages.com/asr/b1e20ef5-d087-4376-a9b5-a2c916432b63.f55fec47df272d798116a3f344b57e11.jpeg");
            imageView.setImage(image);
            imageView.setFitHeight(370);
            imageView.setFitWidth(300);
            vBox.getChildren().addAll(imageView,title,price);
            flowPane.getChildren().add(vBox);
        }
    }
}
