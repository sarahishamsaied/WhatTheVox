package com.example.moviebookingsystem;

import Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class searchUsersController implements Initializable {
    @FXML
    private TableView <User> searchResultsTable;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox <String> filterComboBox;
    ObservableList<String> filterComboBoxItems = FXCollections.observableArrayList("Search By Name","Search By Email");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filterComboBox.setItems(filterComboBoxItems);

    }

}
