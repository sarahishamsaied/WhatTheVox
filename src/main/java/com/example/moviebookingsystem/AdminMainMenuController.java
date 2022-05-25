package com.example.moviebookingsystem;

import DatabaseServices.MealServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainMenuController implements Initializable {
    FileChooser mealImage = new FileChooser();
    @FXML
    ComboBox <String> categoryComboBox;
    @FXML
    TextField mealTitle;
    @FXML
    TextArea mealDescription;
    @FXML
    Button usersNavLink,dashboardNavLink,adminsNavLink,ticketsNavLink,foodNavLink;
    @FXML
    Pane dashboardPane,adminsMenuPane,usersMenuPane,ticketsMenuPane,foodMenuPane;
    ObservableList <String> categoryComboBoxItems = FXCollections.observableArrayList("Food","Drink");

    @FXML
    public void handleNavLinkClick(ActionEvent e){
        if(e.getSource() == usersNavLink)
            usersMenuPane.toFront();
        if(e.getSource() == dashboardNavLink)
            dashboardPane.toFront();
        if(e.getSource() == adminsNavLink)
            adminsMenuPane.toFront();
        if(e.getSource() == ticketsNavLink)
            ticketsMenuPane.toFront();
        if(e.getSource() == foodNavLink)
            foodMenuPane.toFront();

    }
    @FXML
    private void onInsertImage(ActionEvent e){
        mealImage.setTitle("Image");
        File file = mealImage.showOpenDialog(null);
        if(file == null){
            return;
        }
        mealImage.getExtensionFilters().add(new FileChooser.ExtensionFilter(".png",".jpeg",".jpg"));
        System.out.println(file.getAbsolutePath());


    }
    @FXML
    private void onSubmitMealForm(){
        FileChooser chooser = new FileChooser();
//        MealServices.addMeal(mealTitle.getText(),mealDescription.getText(),categoryComboBox.getValue(),);
    }
    @FXML
    public void onViewAllUsers() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("UsersTable.fxml","Users Table");
    }
    @FXML
    public void onSearchUsers() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("SearchUsers.fxml","Search Users");
    }
    @FXML
    private void onDeleteUser() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("deleteUserForm.fxml","Delete User");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        categoryComboBox.setItems(categoryComboBoxItems);
    }
}
