package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public final class UserServices  {

    static Connection dbConnection = DatabaseConnection.getInstance().getDbConnection();

    public static ObservableList<User> getAllUsers() throws SQLException{
        dbConnection = DatabaseConnection.getInstance().getDbConnection();
//        Connection connection = dbConnection.getDbConnection();
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
    public static boolean checkUserExists(String email,String password) throws SQLException {
        String pass = "";
        PreparedStatement statement = dbConnection.prepareStatement("select * from users where email = '"+email+"'") ;
        ResultSet resultSet = statement.executeQuery();
       while(resultSet.next()){
           pass = resultSet.getString(("password"));
       }
       return (pass.equals(password));
    }
    public static ObservableList<User> searchUsers(String searchQuery,String searchType) throws SQLException {
        ObservableList<User> searchResult = FXCollections.observableArrayList();
        if(searchType!= "email" && searchType!="name")
            return searchResult;
        Statement sqlStatement = dbConnection.createStatement();
        ResultSet resultSet = sqlStatement.executeQuery("SELECT * FROM users WHERE "+searchType+" REGEXP '"+searchQuery+"'");
        while(resultSet.next()){
            User user = new User();
            user.setName(resultSet.getString("name"));
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
        statement.executeUpdate();
    }
    public static boolean deleteUser(String id) {
        try{
            Statement st = dbConnection.createStatement();
            int rowsAffected = st.executeUpdate("delete from users where userId = '"+id+"'");
            System.out.println(rowsAffected);
            if(rowsAffected !=1)
                return false;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("cannot find id");
        }

        return true;
    }

}
