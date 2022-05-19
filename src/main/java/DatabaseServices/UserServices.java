package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public static boolean checkEmailExists(String email) throws SQLException {
        String user;
        PreparedStatement statement = dbConnection.prepareStatement("select * from users where email = '"+email+"'");
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next()?true:false;
    }

}
