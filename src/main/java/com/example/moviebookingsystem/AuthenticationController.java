package com.example.moviebookingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.sql.*;
public class AuthenticationController {
    Connection testConnection;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "";
            testConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/moviebookingsystem",user,password);
            Statement testStatement = testConnection.createStatement();
            ResultSet testRes = testStatement.executeQuery("select * from users");
            while(testRes.next()){
                System.out.println(testRes.getString("name")+" "+testRes.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("cannot find class");
            e.printStackTrace();
        }
    }

    @FXML
    void onSignUp(ActionEvent actionEvent) {

    }
    @FXML void onSignIn(ActionEvent actionEvent) {

    }
}
