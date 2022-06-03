package com.example.moviebookingsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class AddMovieForm {

    @FXML
    private TextField AddCastTF;

    @FXML
    private TextField AddDateTF;

    @FXML
    private TextField AddMovieTF;

    @FXML
    private ComboBox<?> AgeRatingTF;

    @FXML
    private TextArea DescriptionTF;

    @FXML
    private TextField DurationTF;

    @FXML
    private TextField LanguageTF;

    @FXML
    private TextField PosterTF;

    @FXML
    private TextField ratingTF;

    @FXML
    private TextField trailerTF;
    @FXML
    private Pane PaneOne;

    @FXML
    private Pane PaneTwo;
    @FXML
    private Button BackButton;
    @FXML
    private Button SubmitButton;
    @FXML
    private Button NextButton;

    @FXML
    void OnBackMovie(ActionEvent event) {
        if (event.getSource()==BackButton){
            PaneOne.toFront();
        }

    }

    @FXML
    void OnNext(ActionEvent event) {
        if (event.getSource()==NextButton){
            PaneTwo.toFront();
        }

    }

    @FXML
    void OnSubmitMovie(ActionEvent event) throws IOException {

        Navigator navigator = new Navigator();
        navigator.Navigate("MoviesForm.fxml","MoviesForm");


    }

}

