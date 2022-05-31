package DatabaseServices;

import Classes.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FinanceServices  {
    static Connection dbConnection = DatabaseConnection.getInstance().getDbConnection();
    public static String getTotalBalance() throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("SELECT SUM(amountPaid) as totalSum from purchaseHistory");
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next())
            return resultSet.getString("totalSum");
        return "null";
    }
}
