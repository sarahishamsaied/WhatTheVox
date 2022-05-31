package com.example.moviebookingsystem;

import Classes.DatabaseConnection;
import DatabaseServices.UserServices;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class DeleteUserController {
    @FXML
    TextField deletedUserId;
    @FXML
    private Label statusMessage;
    @FXML
    public void onDeleteUser() throws SQLException {
        DatabaseConnection db = DatabaseConnection.getInstance();
        db.Connect();
        if(!UserServices.deleteUser(deletedUserId.getText())){
            statusMessage.setText("cannot find user");
            statusMessage.setTextFill(Color.color(1, 0, 0));
        }
        else
        {
            statusMessage.setText("deleted successfully");
            statusMessage.setTextFill(Color.color(0, 1, 0));
        }

    }
}
