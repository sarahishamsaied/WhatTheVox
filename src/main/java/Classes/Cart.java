package Classes;

import java.util.ArrayList;

public class Cart {
    static Double totalBalance;
    static ArrayList<Meal> cartItems;
    static ArrayList<Ticket> ticketsCart;
    public Cart(Meal meal) {

    }
    public static void addToCart(Meal meal){
        cartItems.add(meal);
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
