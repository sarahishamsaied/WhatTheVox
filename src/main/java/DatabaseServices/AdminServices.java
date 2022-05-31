package DatabaseServices;

import Classes.Admin;
import Classes.DatabaseConnection;

import java.sql.*;

public class AdminServices {
    static Connection dbConnection  = DatabaseConnection.getInstance().getDbConnection();
    /**
     * Adds an admin to the database
     * @param name Admin Name
     * @param age Admin Age
     * @param loginId Admin Login ID (UNIQUE)
     * @param loginPassword Admin Password
     * @return void
     * @throws SQLException*/
    public static void addAdmin(String name,int age,String loginId,String loginPassword) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("insert into admins(name,age,loginId,loginPassword)values(?,?,?,?)");
        statement.setString(1,name);
        statement.setInt(2,age);
        statement.setString(4,loginId);
        statement.setString(4,loginPassword);
        statement.executeUpdate();
    }
    /**
     * Admin Authentication
     * Checks whether login Id exists
     * Checks whether LoginId matches the password attempt
     * @param loginId  Login Id attempt
     * @param password password attempt
     * @return boolean
     * @throws SQLException*/
    public static boolean authenticateAdmin(String loginId,String password) throws SQLException {
        String pass = "";
        PreparedStatement statement = dbConnection.prepareStatement("select * from admins where adminLoginId = ?");
        statement.setString(1,loginId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
          pass = resultSet.getString("adminPassword");
        }
        return password.equals(pass);
    }
    public static Admin getAdmin(String loginId) throws SQLException {
        String id = "",name = "";
        int age = 0;
        if (checkLoginIdExists(loginId))
        {
            PreparedStatement statement = dbConnection.prepareStatement("select * from admins where adminLoginId = ?");
            statement.setString(1,loginId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                id =  resultSet.getString("adminLoginId");
                name =  resultSet.getString("name");
                age =  resultSet.getInt("age");
            }
            return new Admin(name,age,loginId);
        }
       return new Admin();
    }

    /**
     * Checks whether the attempted login Id exists in the database or not
     * @param loginId The attempted Login Id
     * @return boolean
     * @throws SQLException*/
    public static boolean checkLoginIdExists(String loginId) throws SQLException {
        PreparedStatement statement = dbConnection.prepareStatement("select * from admins where adminLoginId = ?");
        statement.setString(1,loginId);
        ResultSet resultSet = statement.executeQuery();
        return resultSet.next()?true:false;
    }
    /**
     * Deletes an admin from the databse
     * @param adminId Login Id attempt
     * @return boolean
     * @throws SQLException*/
    public static boolean deleteAdmin(String adminId) {
        try{
            Statement statement = dbConnection.createStatement();
            int rowsAffected = statement.executeUpdate("delete from users where adminId = '"+adminId+"'");
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
