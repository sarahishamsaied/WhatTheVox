package com.example.moviebookingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AdminMainMenuController {
    @FXML
    Button usersNavLink,dashboardNavLink,adminsNavLink,ticketsNavLink,foodNavLink;
    @FXML
    Pane dashboardPane,adminsMenuPane,usersMenuPane,ticketsMenuPane,foodMenuPane;
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

}
