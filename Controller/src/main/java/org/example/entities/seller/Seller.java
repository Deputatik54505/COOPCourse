package org.example.entities.seller;

import org.example.entities.cart.ShoppingCart;
import org.example.entities.user.User;

public class Seller {
    public final User user;

    public final ShoppingCart shoppingCart;

    public Seller(User user) {
        this.user = user;
        this.shoppingCart = new ShoppingCart();
    }

}
