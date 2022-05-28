package Classes;

import java.util.ArrayList;

public class CinemaHall {
    String cinemaType;
    int noOfSeats;
  //  ArrayList<Movie> movies;
    int cinemaNo;

    public CinemaHall(String cinemaType, int noOfSeats, int cinemaNo) {
        this.cinemaType = cinemaType;
        this.noOfSeats = noOfSeats;
        this.cinemaNo = cinemaNo;
    }

    public String getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(String cinemaType) {
        this.cinemaType = cinemaType;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getCinemaNo() {
        return cinemaNo;
    }

    public void setCinemaNo(int cinemaNo) {
        this.cinemaNo = cinemaNo;
    }
}
