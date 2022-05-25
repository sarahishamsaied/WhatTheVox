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
    public static void addMeal(String title,String description,String category,File image) throws SQLException, FileNotFoundException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("insert into meals (title,description,category,imageUrl)values(?,?,?,?)");
        sqlStatement.setString(1,title);
        sqlStatement.setString(2,description);
        FileInputStream imageFile = new FileInputStream(image);
        sqlStatement.setString(3,category);
        sqlStatement.setBinaryStream(4,imageFile,image.length());
    }
    public static ObservableList<Meal> viewAllMeals() throws SQLException {
        ObservableList<Meal> allMeals = FXCollections.observableArrayList();
        PreparedStatement sqlStatement = dbConnection.prepareStatement("select * from meals");
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            Meal meal = new Meal(resultSet.getString("title"),resultSet.getString("description"),resultSet.getString("category"), (FileInputStream) resultSet.getBinaryStream("image"));
            allMeals.add(meal);
        }
        return allMeals;
    }

}
