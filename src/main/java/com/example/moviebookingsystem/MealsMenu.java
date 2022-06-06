package com.example.moviebookingsystem;

import Classes.Meal;
import DatabaseServices.MealServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MealsMenu implements Initializable {
    @FXML
    ScrollPane usersMealsView;
    @FXML
    FlowPane mealsFlowPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            for (Meal meal : MealServices.viewAllMeals()){
                VBox vBox = new VBox();
                Button button = new Button();
                button.setText("Pre-Order");
                button.setBackground(Background.fill(Color.web("#E11146")));
                button.setTextFill(Color.WHITE);
                VBox.setMargin(button,new Insets(30,0,0,0));
                VBox.setMargin(vBox,new Insets(50,50,50,50));
                vBox.setPadding(new Insets(30,30,30,30));
                ImageView imageView = new ImageView();
                Image img = new Image(meal.getImageURL());
                imageView.setFitWidth(300);
                imageView.setFitHeight(350);
                imageView.setImage(img);
                Label title;
                if (meal.getQuantity()<=0) {
                    title = new Label(meal.getMealTitle()+" (Out of stock)");
                    title.setTextFill(Color.RED);
                    title.setBackground(Background.fill(Color.rgb(255,0,0,.4)));
                }
                else title = new Label(meal.getMealTitle());
                title.setPadding(new Insets(10,0,10,0));
                Label price = new Label("$"+meal.getPrice());
                price.setFont(new Font("Arial",20));
                price.setTextFill(Color.WHITE);
                title.setTextFill(Color.WHITE);
                title.setFont(new Font("Arial",28));
                vBox.getChildren().addAll(imageView,title,price,button);
                mealsFlowPane.getChildren().add(vBox);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
