package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public  class DatabaseConnection {
   protected static Connection dbConnection;
    final String getAllUsersStatement = "select * from users";
    final String searchStatement = "select * from users where ";
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "";
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/moviebookingsystem",user,password);
//            Statement testStatement = dbConnection.createStatement();
//            ResultSet testRes = testStatement.executeQuery("select * from users");
//            while(testRes.next()){
//                System.out.println(testRes.getString("name")+" "+testRes.getString("email"));
//            }
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
