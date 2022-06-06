package com.example.moviebookingsystem;

import Classes.*;
import DatabaseServices.MovieServices;
import DatabaseServices.PurchaseServices;
import DatabaseServices.ReportServices;
import DatabaseServices.TicketServices;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class MoviesHome implements Initializable {

    @FXML
    private Button comingSoonButton;

    @FXML
    private FlowPane comingSoonFlowPane;

    @FXML
    private Pane comingSoonPane;

    @FXML
    private Button logoutButton;

    @FXML
    private Button settingsButton,oldiesButton;

    @FXML
    private Button trendingButton;

    @FXML
    private FlowPane oldiesFlowPane;

    @FXML
    private Pane oldiesPane,seatsPane,MovieDetailsPane;
    @FXML
    private Pane settingsPane;

    @FXML
    private Button whatsOnButton;

    @FXML
    private FlowPane whatsOnFlowPane;

    @FXML
    private Pane whatsOnPane,seatsPane2;
    @FXML
    private TextField updatedEmailTF;

    @FXML
    private TextField updatedPasswordTF;

    @FXML
    private TextField updatedUserNameTF;
    @FXML
    private Button SelectSeatbutton;
    @FXML
    private Button GoBackButton;
    @FXML
    ImageView selectedImage;




    @FXML
    private Label priceLabel;
    @FXML
    private GridPane seatsGridPane;
    @FXML
    private Label ErrorLabel;

    @FXML
    private ChoiceBox<String> HallBox;
    public String[]hall={"MAX", "GOLD"};

    @FXML
    private ChoiceBox<String> TimeBox;
    public String[]time={"3:00 PM","6:00 PM","9:00 PM","12:00 AM"};

    Set<String> set = new HashSet<String>();
    @FXML
    ImageView movieImageMD;
    @FXML
    private Label SelectedLabel,movieNameMD,ratingMD,ageRatingMD,movieDurationMD,movieLanguageMD,movieOverviewMD;
    @FXML
    private Hyperlink trailerLinkMD;

    @FXML
    private DatePicker datePicker;
    LocalDate myDate;

    @FXML
    private Button SubmitT;

    @FXML
    private Button CalculateButton;

    @FXML
    private Spinner<Integer> SeatSpinner;
    int CurrentValue;
    Integer y;

    @FXML
    private ChoiceBox<String> PayBox;
    public String[] pay ={"Cash","MaterCard","PayPal"};
    @FXML
    void OnClick(ActionEvent event) throws UnknownHostException, SQLException, JRException, ParseException {
        String x="";

        if (event.getSource()==SelectSeatbutton)
            seatsPane.toFront();

        if (event.getSource()==SubmitT){
            System.out.println("test");
            if (set.size()!=SeatSpinner.getValue())
            {
                ErrorLabel.setText("Please enter the correct seat number");
                return;
            }
            for(String id : set){
                x += id + " ";
            }
            ErrorLabel.setText("");
            Context ctx = Context.getInstance();
            TicketID ticketID = new TicketID();
            System.out.println("execute");
            System.out.println(Price(SeatSpinner.getValue(), HallBox.getValue()));
            Ticket myTicket = new Ticket(x,ticketID.generateUniqueId(),HallBox.getValue(),(double)Price(SeatSpinner.getValue(),HallBox.getValue()),myDate.toString(),PayBox.getValue());
            TicketServices.addTicket(myTicket.getTicketNo(),ctx.getCurrentUser().getUserId(),ctx.getMovie().getMovieId(), myTicket.getTicketType(), myTicket.getSeatNo(),myTicket.getTicketPrice(),ctx.getMovie().getMovieName());
            ReportServices.printTicket("ticket3.jrxml",myTicket.getTicketNo());
            PurchaseServices.sell(new Purchase(ctx.getMovie().getMovieName(),myTicket.getTicketPrice(),new PurchaseID().generateUniqueId()));
        }
        SelectedLabel.setText(x);
        if (event.getSource()==CalculateButton){
            priceLabel.setText(String.valueOf(Price(SeatSpinner.getValue(),HallBox.getValue())));
        }

    }
    @FXML
    void OnBack(ActionEvent event) {
        if(event.getSource()==GoBackButton)
            seatsPane2.toFront();}



    @FXML
    void OnChange(ActionEvent event) {
        System.out.println("onchange");
        String x="";
        ObservableList<Node> children = seatsGridPane.getChildren();
        for (Node child : children){
            if (child instanceof CheckBox){
                if (((CheckBox) child).isSelected()){
                    System.out.println("hi");
                    System.out.println(child.getId());
                    set.add(child.getId());
                }
            }

        }
        for(String id : set){
            x+=id+" " ;

        }
        System.out.println(set.size());


    }
    public void getHall(ActionEvent event){
        String myHall=HallBox.getValue();


    }
    public void getpayment(ActionEvent event){
        String pay=PayBox.getValue();



    }
    public void getTime(ActionEvent event){
        String myTime=TimeBox.getValue();


    }
    public Integer Price(Integer seats,String HallBox){

        if (HallBox=="MAX"){
            return seats*100;
        }
        return y= seats*150;
    }
    @FXML
    void OnDate(ActionEvent event) {
        myDate = datePicker.getValue();
    }
    public void setOldiesPaneItems(){
        try {
            oldiesFlowPane.getChildren().clear();
            for (Movie movie : MovieServices.filterMovies("OLDIES")){
                VBox vBox = new VBox();
                Label title = new Label(movie.getMovieName());
                Label category = new Label(movie.getCategory());
                Button button = new Button("Book Now");
                Button checkDetailsButton = new Button("Check Details");
                Image image = new Image(movie.getImageUrl());
                System.out.println(movie.getImageUrl());
                ImageView poster = new ImageView();
                poster.setImage(image);
                poster.setFitHeight(400);
                poster.setFitWidth(300);
                vBox.setPadding(new Insets(30,30,30,30));
                category.setTextFill(Color.WHITE);
                button.setBackground(Background.fill(Color.web("#EE6186")));
                checkDetailsButton.setBackground(Background.fill(Color.web("#EE6186")));
                button.setTextFill(Color.WHITE);
                checkDetailsButton.setTextFill(Color.WHITE);
                vBox.setSpacing(10);
                title.setTextFill(Color.WHITE);
                title.setFont(new Font("Arial",28));
                vBox.getChildren().addAll(poster,title,category,button,checkDetailsButton);
                oldiesFlowPane.getChildren().add(vBox);
                button.setOnAction(e->{
                    seatsPane2.toFront();
                    selectedImage.setImage(new Image(movie.getImageUrl()));
                    Context ctx = Context.getInstance();
                    ctx.setMovie(movie);

                });
                checkDetailsButton.setOnAction(e->{
                    movieNameMD.setText(movie.getMovieName());
                    ratingMD.setText(String.valueOf(movie.getRating()));
                    ageRatingMD.setText(movie.getAgeRating());
                    movieDurationMD.setText(movie.getDuration());
                    movieLanguageMD.setText(movie.getLanguage());
                    trailerLinkMD.setText(movie.getTrailer());
                    movieOverviewMD.setText(movie.getOverview());
                    movieImageMD.setImage(new Image(movie.getImageUrl()));
                    MovieDetailsPane.toFront();
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleMenuClick(ActionEvent event) {
        if (event.getSource() == whatsOnButton)
            whatsOnPane.toFront();
        if (event.getSource() == oldiesButton)
        {
            oldiesPane.toFront();
            setOldiesPaneItems();
        }
        if (event.getSource() == comingSoonButton)
            comingSoonPane.toFront();
        if (event.getSource() == settingsButton)
            settingsPane.toFront();
    }

    @FXML
    void onSubmitChanges(ActionEvent event) {

    }

    @FXML
    void onViewLastBookedTicket(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> mySeatSpinner= new SpinnerValueFactory.IntegerSpinnerValueFactory(1,25);
        mySeatSpinner.setValue(1);
        SeatSpinner.setValueFactory(mySeatSpinner);
        HallBox.getItems().addAll(hall);
        HallBox.setOnAction(this::getHall);
        TimeBox.getItems().addAll(time);
        TimeBox.setOnAction(this::getTime);
        PayBox.getItems().addAll(pay);
        PayBox.setOnAction(this::getpayment);
//        posterImage.setImage(new Image(""));
        DatabaseConnection db = DatabaseConnection.getInstance();
        try {
            for (Movie movie : MovieServices.getAllMovies()){
                VBox vBox = new VBox();
                Label title = new Label(movie.getMovieName());
                Label category = new Label(movie.getCategory());
                Button button = new Button("Book Now");
                Button checkDetailsButton = new Button("Check Details");
                Image image = new Image(movie.getImageUrl());
                System.out.println(movie.getImageUrl());
                ImageView poster = new ImageView();
                poster.setImage(image);
                poster.setFitHeight(400);
                poster.setFitWidth(300);
                vBox.setPadding(new Insets(30,30,30,30));
                category.setTextFill(Color.WHITE);
                button.setBackground(Background.fill(Color.web("#EE6186")));
                checkDetailsButton.setBackground(Background.fill(Color.web("#EE6186")));
                button.setTextFill(Color.WHITE);
                checkDetailsButton.setTextFill(Color.WHITE);
                vBox.setSpacing(10);
                title.setTextFill(Color.WHITE);
                title.setFont(new Font("Arial",28));
                vBox.getChildren().addAll(poster,title,category,button,checkDetailsButton);
                whatsOnFlowPane.getChildren().add(vBox);
                button.setOnAction(e->{
                    seatsPane2.toFront();
                    selectedImage.setImage(new Image(movie.getImageUrl()));
                    Context ctx = Context.getInstance();
                    ctx.setMovie(movie);

                });
                checkDetailsButton.setOnAction(e->{
                    movieNameMD.setText(movie.getMovieName());
                    ratingMD.setText(String.valueOf(movie.getRating()));
                    ageRatingMD.setText(movie.getAgeRating());
                    movieDurationMD.setText(movie.getDuration());
                    movieLanguageMD.setText(movie.getLanguage());
                    trailerLinkMD.setText(movie.getTrailer());
                    movieOverviewMD.setText(movie.getOverview());
                    movieImageMD.setImage(new Image(movie.getImageUrl()));
                    MovieDetailsPane.toFront();
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
