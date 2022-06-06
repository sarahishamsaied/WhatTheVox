package DatabaseServices;

import Classes.Actor;
import Classes.DatabaseConnection;
import Classes.Movie;
import Classes.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MovieServices {
    public static Connection dbConnection = DatabaseConnection.getInstance().getDbConnection();
    public static void addMovie(String movieId,String movieName, String releaseDate, String category, Double rating, String trailer, String duration, String language, String schedule, String ageRating, String overview,String imageUrl) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("insert into movies(movieId,name,releaseDate,category,overview,imageUrl,duration,language,trailer,rating,schedule,ageRating)values(?,?,?,?,?,?,?,?,?,?,?,?)");
        statement.setString(1,movieId);
        statement.setString(2,movieName);
        statement.setString(3,releaseDate);
        statement.setString(4,category);
        statement.setString(5,overview);
        statement.setString(6,imageUrl);
        statement.setString(7,duration);
        statement.setString(8,language);
        statement.setString(9,trailer);
        statement.setDouble(10,rating);
        statement.setString(11,schedule);
        statement.setString(12,ageRating);
        statement.executeUpdate();
    }
    public static ObservableList<Movie> getAllMovies() throws SQLException {
        ObservableList <Movie> movies = FXCollections.observableArrayList();
        PreparedStatement statement = dbConnection.prepareStatement("select * from movies");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Movie movie = new Movie(resultSet.getString("movieId"),resultSet.getString("name"),resultSet.getString("releaseDate"),resultSet.getString("category"),resultSet.getDouble("rating"),resultSet.getString("trailer"),resultSet.getString("duration"),resultSet.getString("language"),resultSet.getString("schedule"),resultSet.getString("ageRating"),resultSet.getString("overview"),resultSet.getString("imageUrl"));
            movies.add(movie);
        }
        return movies;
    }
    public static String getMovieName(String movieId) throws SQLException {
        String movieName = "";
        PreparedStatement statement = dbConnection.prepareStatement("select * from movies where movieId = ? ");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            movieName = resultSet.getString(movieId);
        }
        return movieName;
    }
    public static ObservableList<Movie> filterMovies(String category) throws SQLException {
        ObservableList<Movie> movies = FXCollections.observableArrayList();
        PreparedStatement statement = dbConnection.prepareStatement("select * from movies where category = ?");
        statement.setString(1,category);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Movie movie = new Movie(resultSet.getString("movieId"),resultSet.getString("name"),resultSet.getString("releaseDate"),resultSet.getString("category"),resultSet.getDouble("rating"),resultSet.getString("trailer"),resultSet.getString("duration"),resultSet.getString("language"),resultSet.getString("schedule"),resultSet.getString("ageRating"),resultSet.getString("overview"),resultSet.getString("imageUrl"));
            movies.add(movie);
        }
        return movies;
    }

}
