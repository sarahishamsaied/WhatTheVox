package Classes;

import java.util.Date;

public class Ticket {
    String seatNo;
    String ticketNo;
    String ticketType;
    Double ticketPrice;
//    Movie movie;
    Payment payment;
    Date currentDate;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Ticket(String seatNo, String ticketNo, String ticketType, Double ticketPrice, Payment payment, Date currentDate) {
        this.seatNo = seatNo;
        this.ticketNo = ticketNo;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;
        this.payment = payment;
        this.currentDate = currentDate;
    }
}
