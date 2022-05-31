package com.example.moviebookingsystem;

import Classes.DatabaseConnection;
import Classes.User;
import DatabaseServices.UserServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class searchUsersController implements Initializable {
    @FXML
    TableColumn <User,String> UserNameColumn,UserAgeColumn,UserEmailColumn;
    @FXML
    private TableView <User> searchResultsTable;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox <String> filterComboBox;
    ObservableList<String> filterComboBoxItems = FXCollections.observableArrayList("Search By Name","Search By Email");
    @FXML
    public void onSearchClicked() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.Connect();
        if(filterComboBox.getValue() == "Search By Name" || filterComboBox.getValue() == null)
        searchResultsTable.setItems(UserServices.searchUsers(searchField.getText(),"name"));
        if(filterComboBox.getValue() == "Search By Email")
            searchResultsTable.setItems(UserServices.searchUsers(searchField.getText(),"email"));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserNameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
        UserAgeColumn.setCellValueFactory(new PropertyValueFactory<User,String>("age"));
        UserEmailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        filterComboBox.setItems(filterComboBoxItems);
    }

}
