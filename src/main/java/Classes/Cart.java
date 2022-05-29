package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    static Double totalBalance;
    static ArrayList<Meal> cartItems = new ArrayList<Meal>(100);
    static ArrayList<Ticket> ticketsCart;

    public static Double getTotalBalance() {
        return totalBalance;

    }

    public static void setTotalBalance(Double totalBalance) {
        Cart.totalBalance = totalBalance;
    }

    public static ArrayList<Meal> getCartItems() {
        System.out.println("cart items");
        for (Meal element : cartItems)
            System.out.println(element.mealTitle);
        return cartItems;
    }

    public static void setCartItems(ArrayList<Meal> cartItems) {
        Cart.cartItems = cartItems;
    }

    public static ArrayList<Ticket> getTicketsCart() {
        return ticketsCart;
    }

    public static void setTicketsCart(ArrayList<Ticket> ticketsCart) {
        Cart.ticketsCart = ticketsCart;
    }

    public Cart() {
        cartItems =  new ArrayList<Meal>(100);
        ticketsCart = new ArrayList<Ticket>(100);
        totalBalance = 0.0;
    }
    public static void addToCart(Meal meal){
        Cart.cartItems.add(meal);
        for (Meal element : cartItems)
            totalBalance+=element.getPrice();
    }
    public static void removeFromCart(String mealTitle){
    if (cartItems.isEmpty())
        return;
    for (Meal element : cartItems)
    {
        if(element.mealTitle.equals(mealTitle))
            cartItems.remove(element);
    }
    }
    public Cart(Ticket ticket) {
        this.ticketsCart.add(ticket);
    }
}
