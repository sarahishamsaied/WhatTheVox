package Classes;

import java.util.ArrayList;
import java.util.Locale;

public class User extends Person {
    String email;
    String password;
    ArrayList<Ticket> tickets;
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
    public User(String name, int age,String email, String password, ArrayList<Ticket> tickets) {
        super(name,age);
        this.email = email.toLowerCase();
        this.password = password.toLowerCase();
        this.tickets = tickets;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public User(String name,int age,String email, String password) {
        super(name,age);
        this.email = email;
        this.password = password;
    }



}
