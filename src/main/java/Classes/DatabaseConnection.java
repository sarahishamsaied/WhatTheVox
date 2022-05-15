package Classes;

import java.sql.*;

public class DatabaseConnection {
    Connection testConnection;
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String password = "";
            testConnection = DriverManager.getConnection("jdbc:mysql://localhost:3307/moviebookingsystem",user,password);
            Statement testStatement = testConnection.createStatement();
            ResultSet testRes = testStatement.executeQuery("select * from users");
            while(testRes.next()){
                System.out.println(testRes.getString("name")+" "+testRes.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("cannot find class");
            e.printStackTrace();
        }
    }
}
