package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.Purchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseServices extends DatabaseConnection {
    public static void sell(Purchase purchase) throws SQLException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("insert into purchaseHistory(itemName,amountPaid) values(?,?)");
        sqlStatement.setString(1,purchase.getItemName());
        sqlStatement.setDouble(2,purchase.getAmountPaid());
        sqlStatement.executeUpdate();
    }
    public static ObservableList<Purchase> getPurchaseHistory() throws SQLException {
        ObservableList<Purchase> history = FXCollections.observableArrayList();
        PreparedStatement sqlStatement = dbConnection.prepareStatement("select * form purchaseHistory");
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            Purchase purchase = new Purchase(resultSet.getString("itemName"),resultSet.getDouble("amountPaid"));
        }
        return history;
    }
}
