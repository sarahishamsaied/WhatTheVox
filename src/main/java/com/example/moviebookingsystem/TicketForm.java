package com.example.moviebookingsystem;

import Classes.Context;
import Classes.Payment;
import Classes.Ticket;
import Classes.TicketID;
import DatabaseServices.TicketServices;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class TicketForm implements Initializable {
    @FXML
    private Button SelectSeatbutton;
    @FXML
    private Button GoBackButton;
    @FXML
    ImageView posterImage;
    @FXML
    private Pane Page1;

    @FXML
    private Pane Page2;

    @FXML
    private Label priceLabel;

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
    private Label SelectedLabel;

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
    public void onSubmitTicket(){
        System.out.println("test");
    }
    @FXML
    void OnClick(ActionEvent event) throws UnknownHostException, SQLException {
        String x="";

        if (event.getSource()==SelectSeatbutton)
            Page2.toFront();

        if (event.getSource()==SubmitT){
            System.out.println("test");
//            if (set.size()!=SeatSpinner.getValue())
//            {
//                ErrorLabel.setText("Please enter the correct seat number");
//                return;
//            }
            for(String id : set){
                x += id + " ";
            }
            ErrorLabel.setText("");
            Context ctx = Context.getInstance();
            TicketID ticketID = new TicketID();
            System.out.println("execute");
            Ticket myTicket = new Ticket(String.valueOf(SeatSpinner.getValue()),ticketID.generateUniqueId(),HallBox.getValue(),(double)Price(SeatSpinner.getValue(),HallBox.getValue()),myDate.toString(),PayBox.getValue());
            TicketServices.addTicket(myTicket.getTicketNo(),ctx.getCurrentUser().getUserId(),ctx.getMovie().getMovieId(), myTicket.getTicketType(), myTicket.getSeatNo(),myTicket.getTicketPrice(),ctx.getMovie().getMovieName());
        }
        SelectedLabel.setText(x);
        if (event.getSource()==CalculateButton){
            priceLabel.setText(String.valueOf(Price(SeatSpinner.getValue(),HallBox.getValue())));
        }

    }
    @FXML
    void OnBack(ActionEvent event) {
        if(event.getSource()==GoBackButton)
            Page1.toFront();}


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
        posterImage.setImage(new Image(""));
        
    }
    @FXML
    void OnChange(ActionEvent event) {
        String x="";

        ObservableList<Node> children = Page2.getChildren();
        for (Node child : children){
            if (child instanceof CheckBox){
                if (((CheckBox) child).isSelected()){
                    set.add(child.getId());

                }
            }

        }
        for(String id : set){
            x+=id+" " ;

        }
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





}

