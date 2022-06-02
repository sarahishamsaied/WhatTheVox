package DatabaseServices;

import Classes.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Counter  {
    static Connection dbConnection = DatabaseConnection.getInstance().getDbConnection();
    public static String getTotalBalance() throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("SELECT SUM(amountPaid) as totalSum from purchaseHistory");
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next())
            return resultSet.getString("totalSum");
        return "0";
    }
    public static Integer noOfAdmins() throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("SELECT COUNT(*) FROM admins");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            return resultSet.getInt(1);
        return 0;
    }
    public static Integer noOfUsers() throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("SELECT COUNT(*) FROM users");
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            return resultSet.getInt(1);
        return 0;
    }
    public static double getIncome(int month,int year) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("select SUM(amountPaid) as MonthlyIncome from purchaseHistory where MONTH(timeOfPurchase) = ? AND  YEAR(timeOfPurchase) = ?");
        statement.setInt(1,month);
        statement.setInt(2,year);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
        {
            return Double.parseDouble(resultSet.getString("MonthlyIncome"));
        }
        return 0;
    }
}
