package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class UserServices extends DatabaseConnection {
    public static ObservableList<User> getAllUsers() throws SQLException{
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        String x = "";
        Statement sqlStatement = dbConnection.createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("select * from users");
        while(resultSet.next()){
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(Integer.parseInt(resultSet.getString("age")));
            allUsers.add(user);
//            System.out.println(resultSet.getString("name")+" "+resultSet.getString("email") + resultSet.getString("age") + resultSet.getString("ticketId"));
        }
        return allUsers;
    }
    public static ObservableList<User> searchUsers(String searchQuery) throws SQLException {
        ObservableList<User> searchResult = FXCollections.observableArrayList();
        Statement sqlStatement = dbConnection.createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("SELECT name FROM users WHERE name REGEXP '"+searchQuery+"'");
        while(resultSet.next()){
            User user = new User();
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(Integer.parseInt(resultSet.getString("age")));
            searchResult.add(user);
        }
        return searchResult;
    }
    public static boolean checkEmailExists(String email) throws SQLException {
        String user;
        PreparedStatement statement = dbConnection.prepareStatement("select * from users where email = '"+email+"'");
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next()?true:false;
    }
    public static void addUser(String name,int age,String email,String password) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("insert into users(name,age,email,password)values(?,?,?,?)");
        statement.setString(1,name);
        statement.setInt(2,age);
        statement.setString(3,email);
        statement.setString(4,password);
//        statement.setString(6,"fffff");
        statement.executeUpdate();
    }

}
