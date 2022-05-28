package com.example.moviebookingsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    public void onSignUp() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("signUp.fxml","Sign Up");
    }
    @FXML
    private void goToAdminLoginPage() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("adminLogin.fxml","Admin Login");
    }
    @FXML
    public void onSignIn() throws IOException {
        Navigator navigator = new Navigator();
        navigator.Navigate("signIn.fxml","Sign In");
    }

}