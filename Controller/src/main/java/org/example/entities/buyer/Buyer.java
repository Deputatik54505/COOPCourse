package org.example.entities.buyer;

import org.example.entities.cart.ShoppingCart;
import org.example.entities.product.Product;
import org.example.entities.user.User;
import org.example.validation.exceptions.ProductNotFoundExc;

public class Buyer {
    public final User user;
    public final ShoppingCart shoppingCart;
    private int buyerId;

    public Buyer(User user) {
        this.user = user;
        this.shoppingCart = new ShoppingCart();
    }

    public void loadCart() {

    }

    public void buyProduct(Product product) throws ProductNotFoundExc {
        this.shoppingCart.removePurchase(product);
        product.addAmount(-1);
    }
}
