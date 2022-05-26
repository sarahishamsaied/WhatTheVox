package com.example.moviebookingsystem;

import Classes.DatabaseConnection;
import Classes.Meal;
import DatabaseServices.MealServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminMainMenuController implements Initializable {
    Meal selectedMeal;
    @FXML
    ComboBox <String> categoryComboBox;
    @FXML
    TextField mealTitle,mealPrice,mealQuantity,soldMealQuantity;
    @FXML
    Pane dashboardPane,adminsMenuPane,usersMenuPane,ticketsMenuPane,foodMenuPane,addMealPane,mealsTable,sellMealPane;
    @FXML
    TextArea mealDescription;
    @FXML
    ListView<String> mealsList;
    @FXML
    TableColumn<Meal,String> MealTitleColumn,MealCategoryColumn,MealDescColumn;
    @FXML
    TableColumn<Meal,Double>MealPriceColumn;
    @FXML
    TableColumn<Meal,Integer>MealQuantityColumn;
    @FXML
    Button usersNavLink,dashboardNavLink,adminsNavLink,ticketsNavLink,foodNavLink,addMeal,viewAllMealsButton,sellMeal;
    @FXML
    Label errorMessage;
    ObservableList <String> categoryComboBoxItems = FXCollections.observableArrayList("Food","Drink");
    @FXML
    TableView<Meal> allMealsTable;
    @FXML
    public  void onAddToCart() throws IOException {
        if(selectedMeal.getQuantity()<Integer.parseInt(soldMealQuantity.getText()))
        {
            errorMessage.setText("Quantity not available in storage!");
            return;
        }
        else if(Integer.parseInt(soldMealQuantity.getText())<=0)
        {
            errorMessage.setText("Please enter a number greater than 0!");
            return;
        }
        Navigator navigator = new Navigator();
        navigator.Navigate("Cart.fxml","Cart");
    }
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
    public void onViewAllMeals() throws SQLException {
        mealsTable.toFront();
        allMealsTable.setItems(MealServices.viewAllMeals());
        MealTitleColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("mealTitle"));
        MealCategoryColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("category"));
        MealPriceColumn.setCellValueFactory(new PropertyValueFactory<Meal,Double>("price"));
        MealQuantityColumn.setCellValueFactory(new PropertyValueFactory<Meal,Integer>("quantity"));
        MealDescColumn.setCellValueFactory(new PropertyValueFactory<Meal,String>("description"));

    }
//    @FXML
//    public void handleListClick(ActionEvent event){
////        System.out.println(mealsList.getSelectionModel().getSelectedItem());
//        System.out.println("hi");
//    }
    @FXML
    public void handleAdminMenuClick(ActionEvent e) throws SQLException {
        ObservableList<String> mealsListObsv = FXCollections.observableArrayList();
        if(e.getSource() == addMeal)
            addMealPane.toFront();
        if(e.getSource() == sellMeal)
        {
            sellMealPane.toFront();
            for(Meal element : MealServices.viewAllMeals()){
                mealsListObsv.add(element.getMealTitle());
            }
            mealsList.setItems(mealsListObsv);
            mealsList.setOnMouseClicked(event->{
                try {
                    for(Meal element:MealServices.viewAllMeals())
                    {
                        if(element.getMealTitle().equals(mealsList.getSelectionModel().getSelectedItem()))
                            selectedMeal = element;
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    @FXML
    private void onSubmitMealForm() throws SQLException, FileNotFoundException {
        DatabaseConnection db = new DatabaseConnection();
        db.Connect();
        MealServices.addMeal(mealTitle.getText(),mealDescription.getText(),categoryComboBox.getValue(),Double.parseDouble(mealPrice.getText()),Integer.parseInt(mealQuantity.getText()));
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
