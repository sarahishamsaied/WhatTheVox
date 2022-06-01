package com.example.moviebookingsystem;

import Classes.Style;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController  {
    @FXML
    Button adminButton,signInButton,signUpButton;
    @FXML
    private Label welcomeText;
    @FXML
    public void onHover(){
        Style.changeColorOnHover(adminButton,"#fff","#000","#000","fff");
        Style.changeColorOnHover(signInButton,"#fff","#000","#000","fff");
        Style.changeColorOnHover(signUpButton,"#fff","#000","#000","fff");
    }
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