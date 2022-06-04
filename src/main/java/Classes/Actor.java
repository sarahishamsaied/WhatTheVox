package Classes;

import java.util.ArrayList;

public class Actor extends Person{
    ArrayList<Movie> movies;
    String nationality;


    public Actor(ArrayList<Movie> movies, String nationality) {
        this.movies = movies;
        this.nationality = nationality;
    }

    public Actor(String name, int age, ArrayList<Movie> movies, String nationality) {
        super(name, age);
        this.movies = movies;
        this.nationality = nationality;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
