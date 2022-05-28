package DatabaseServices;

import Classes.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServices extends DatabaseConnection {
    public static boolean checkAdminExists(String loginId,String password) throws SQLException {
        String pass = "";
        PreparedStatement statement = dbConnection.prepareStatement("select * from admins where adminLoginId = ?");
        statement.setString(1,loginId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
          pass = resultSet.getString("adminPassword");
        }
        return password.equals(pass);
    }
}
