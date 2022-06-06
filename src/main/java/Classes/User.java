package Classes;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Locale;

public class User extends Person {
    String userId;
    String email;

    public User(String email, String password) {
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    String password;
    String ticketId;
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(){
        this.email = "";
        this.password = "00000000";
    }
    public User(String name, int age,String email, String password, String ticketId) {
        super(name,age);
        this.email = email.toLowerCase();
        this.password = password.toLowerCase();
        this.ticketId = ticketId;
    }

    public User(String name,int age,String email, String password) {
        super(name,age);
        this.email = email;
        this.password = password;
    }



}
