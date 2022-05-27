package DatabaseServices;

import Classes.DatabaseConnection;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PurchaseServices extends DatabaseConnection {
    public static void sell(String itemName,Double amountPaid) throws SQLException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("insert into purchaseHistory(itemName,amountPaid) values(?,?)");
        sqlStatement.setString(1,itemName);
        sqlStatement.setDouble(2,amountPaid);
        sqlStatement.executeUpdate();
    }
//    public static ObservableList<>
}
