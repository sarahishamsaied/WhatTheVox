package Classes;

import java.util.Date;

public class Ticket {
    String ticketId;
    String seatNo;
    String ticketNo;
    String ticketType;
    Double ticketPrice;
    String paymentMethod;
    Movie movieId;
    String currentDate;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public void printTicket(){

    }
    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Ticket(String seatNo, String ticketNo, String ticketType, Double ticketPrice, String currentDate,String paymentMethod) {
        this.seatNo = seatNo;
        this.ticketNo = ticketNo;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.currentDate = currentDate;
        this.paymentMethod = paymentMethod;
    }
}
