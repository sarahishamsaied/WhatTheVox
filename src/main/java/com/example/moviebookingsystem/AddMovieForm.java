package com.example.moviebookingsystem;
import Classes.MovieID;
import DatabaseServices.MovieServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddMovieForm implements Initializable {
    LocalDate date;

    @FXML
    private TextField AddCastTF;

    @FXML
    private DatePicker ReleaseDP;
    @FXML
    private TextField AddMovieTF;

    @FXML
    private ComboBox<?> AgeRatingTF;
    @FXML
    private ChoiceBox<String> ScheduleBox;
    public String[] sBox={"3:00 PM", "6:00 PM", "9:00 PM", "12:00 AM"};

    @FXML
    private TextArea DescriptionTF;

    @FXML
    private TextField DurationTF;

    @FXML
    private TextField LanguageTF;

    @FXML
    private ChoiceBox<String> CategoryBox;
    public String[] cBOX={"ROMANCE","DRAMA","THRILLER","COMEDY","ACTION","SCIENCE FICTION","WAR","OLDIES","CARMEN FARID"};

    @FXML
    private TextField PosterTF;
    @FXML
    Label statusMessage;
    @FXML
    private TextField ratingTF;

    @FXML
    private TextField trailerTF,MovieIdTF;
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
    private ChoiceBox<String> AgeRateBox;
    public String[]age={"13+","16+","18+","21+"};
    @FXML
    public void onChangeDate(){
         date = ReleaseDP.getValue();
    }
    @FXML
    public void onGenerateUniqueId() throws UnknownHostException {
        MovieID id = new MovieID();
        MovieIdTF.setText(id.generateUniqueId());
    }
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
    void OnSubmitMovie(ActionEvent event) throws IOException, SQLException {
        statusMessage.setText("Movie Added Successfully.");
        MovieServices.addMovie(MovieIdTF.getText(),AddMovieTF.getText(), date.toString(),CategoryBox.getValue(),Double.parseDouble(ratingTF.getText()),trailerTF.getText(),DurationTF.getText(),LanguageTF.getText(),
               ScheduleBox.getValue() ,AgeRateBox.getValue(),DescriptionTF.getText(),PosterTF.getText());

    }
    public void getAgeRate(ActionEvent event){
        String AgeRate =AgeRateBox.getValue();
    }
    public void getCategory(ActionEvent event){
        String Category =CategoryBox.getValue();
    }
    public void getSchedule(ActionEvent event){
        String Schedule =ScheduleBox.getValue();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AgeRateBox.getItems().addAll(age);
        AgeRateBox.setOnAction(this::getAgeRate);
        CategoryBox.getItems().addAll(cBOX);
        CategoryBox.setOnAction(this::getCategory);
        ScheduleBox.getItems().addAll(sBox);
        ScheduleBox.setOnAction(this::getSchedule);
    }
}

