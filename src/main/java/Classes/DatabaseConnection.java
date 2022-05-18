package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public final class DatabaseConnection {
    Connection dbConnection;
    final String getAllUsersStatement = "select * from users";
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
    public ObservableList<User> getAllUsers() throws SQLException{
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
            System.out.println(resultSet.getString("name")+" "+resultSet.getString("email") + resultSet.getString("age") + resultSet.getString("ticketId"));
        }
        return allUsers;
    }
}
