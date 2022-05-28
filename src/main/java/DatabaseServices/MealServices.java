package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.Meal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealServices extends DatabaseConnection {
    public static void addMeal(String title,String description,String category,Double price,int quantity) throws SQLException, FileNotFoundException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("insert into meals (title,description,category,price,quantity)values(?,?,?,?,?)");
        sqlStatement.setString(1,title);
        sqlStatement.setString(2,description);
        sqlStatement.setString(3,category);
        sqlStatement.setDouble(4,price);
        sqlStatement.setInt(5,quantity);
        sqlStatement.executeUpdate();
    }
    public static ObservableList<Meal> viewAllMeals() throws SQLException {
        ObservableList<Meal> allMeals = FXCollections.observableArrayList();
        PreparedStatement sqlStatement = dbConnection.prepareStatement("select * from meals");
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            Meal meal = new Meal(resultSet.getString("title"),resultSet.getString("description"),resultSet.getString("category"),resultSet.getDouble("price"),resultSet.getInt("quantity"));
            allMeals.add(meal);
        }
        return allMeals;
    }
    public static void decrementMealQuantity(String mealTitle,Double decrementValue) throws SQLException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("update meals set quantity = quantity - "+ decrementValue+" where title = '"+mealTitle+"'");
        sqlStatement.executeUpdate();
    }

}
