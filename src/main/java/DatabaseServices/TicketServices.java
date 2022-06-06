package DatabaseServices;

import Classes.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketServices {
    static Connection dbConnection = DatabaseConnection.getInstance().getDbConnection();
    public static void addTicket(String ticketId,String userId,String movieId,String ticketType,String seatNo,Double amountPaid,String movieName) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("update users set ticketId = ? where userId = ?");
        statement.setString(1,ticketId);
        statement.setString(2,userId);
        statement.executeUpdate();
        PreparedStatement statement2 = dbConnection.prepareStatement("insert into tickets(ticketId,movieId,userId,ticketType,seatNo,amountPaid,movieName) values(?,?,?,?,?,?,?) ");
        statement2.setString(1,ticketId);
        statement2.setString(2,movieId);
        statement2.setString(3,userId);
        statement2.setString(4,ticketType);
        statement2.setString(5,seatNo);
        statement2.setDouble(6,amountPaid);
        statement2.setString(7,movieName);
        statement2.executeUpdate();
    }
}
