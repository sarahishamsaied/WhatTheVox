package Classes;

import java.util.ArrayList;
import java.util.Date;

public class Movie {
    String movieName;
    Date releaseDate;
    ArrayList<Actor> cast;
    ArrayList<String> category;
    Double rating;
    String trailer;
    String duration;
    String language;
    ArrayList<Schedule> schedule;
    int ageRating;
    String overview;

    public Movie(String movieName, Date releaseDate, ArrayList<Actor> cast, ArrayList<String> category, Double rating, String trailer, String duration, String language, ArrayList<Schedule> schedule, int ageRating, String overview) {
        this.movieName = movieName;
        this.releaseDate = releaseDate;
        this.cast = cast;
        this.category = category;
        this.rating = rating;
        this.trailer = trailer;
        this.duration = duration;
        this.language = language;
        this.schedule = schedule;
        this.ageRating = ageRating;
        this.overview = overview;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<Actor> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Actor> cast) {
        this.cast = cast;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
