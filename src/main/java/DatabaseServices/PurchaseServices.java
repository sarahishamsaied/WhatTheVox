package DatabaseServices;

import Classes.DatabaseConnection;
import Classes.Purchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PurchaseServices  {
    static Connection dbConnection  = DatabaseConnection.getInstance().getDbConnection();
    public static void sell(Purchase purchase) throws SQLException, ParseException {
        PreparedStatement sqlStatement = dbConnection.prepareStatement("insert into purchaseHistory(itemName,amountPaid,purchaseId) values(?,?,?)");
        sqlStatement.setString(1,purchase.getItemName());
        sqlStatement.setDouble(2,purchase.getAmountPaid());
        sqlStatement.setString(3,purchase.getPurchaseId());
//        Date date = new Date(new SimpleDateFormat("\"dd/MM/yyyy").parse(purchase.getDateOfPurchase()).getTime());
//        sqlStatement.setDate(4,date);
        sqlStatement.executeUpdate();
    }
    public static ObservableList<Purchase> getPurchaseHistory() throws SQLException {
        ObservableList<Purchase> history = FXCollections.observableArrayList();
        PreparedStatement sqlStatement = dbConnection.prepareStatement("select * from purchaseHistory");
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            Purchase purchase = new Purchase(resultSet.getString("itemName"),resultSet.getDouble("amountPaid"),resultSet.getString("purchaseId"));
            history.add(purchase);
        }
        return history;
    }
}
