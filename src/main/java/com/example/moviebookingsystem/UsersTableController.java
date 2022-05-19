package com.example.moviebookingsystem;

import Classes.DatabaseConnection;
import Classes.User;
import Classes.Person;
import DatabaseServices.UserServices;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UsersTableController implements Initializable {
    @FXML
    private TableView<User> usersTable;
    @FXML
    private TableColumn<User,String> IDColumn;
    @FXML
    private TableColumn<User,String> UserNameColumn;
    @FXML
    private TableColumn<User,Integer> AgeColumn;
    @FXML
    private TableColumn<User,String> EmailColumn;
    @FXML
    public void navigate() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("signIn.fxml","Sign In");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            DatabaseConnection db = new DatabaseConnection();
            db.Connect();
            UserServices.getAllUsers();
            usersTable.setItems(UserServices.getAllUsers());
            IDColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
            UserNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
            EmailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
            AgeColumn.setCellValueFactory(new PropertyValueFactory<User,Integer>("age"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
