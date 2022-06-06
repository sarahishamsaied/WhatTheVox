package com.example.moviebookingsystem;

import Classes.Cart;
import Classes.Meal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    @FXML
    ListView<String> cartListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        ArrayList<String> cartList = new ArrayList<>(100);

        System.out.println(Cart.getCartItems().size());
        for (Meal element : Cart.getCartItems()){
            cartList.add(element.getMealTitle()+" "+ element.getPrice()+"x"+element.getQuantity());
            System.out.println(element.getMealTitle()+" "+ element.getPrice());
        }
        cartListView.setItems((ObservableList<String>) cartList);

    }
}