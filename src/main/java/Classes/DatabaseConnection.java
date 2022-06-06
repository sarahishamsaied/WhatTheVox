package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class DatabaseConnection {
   protected static Connection dbConnection;
    static DatabaseConnection db;
    private  DatabaseConnection(){

    }
    public static DatabaseConnection getInstance(){
        if (db == null)
            db = new DatabaseConnection();
        return db;
    }
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "";
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/moviebookingsystem",user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("cannot find class");
            e.printStackTrace();
        }
    }
    public Connection getDbConnection(){
        return dbConnection;
    }

}
