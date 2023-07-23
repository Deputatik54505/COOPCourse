package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.user.User;
import org.example.validation.exceptions.ProductNotFoundExc;

public class Buyer {
    private final User user;

    protected final ShoppingCart shoppingCart;

    public Buyer(User user) {
        this.user = user;
        this.shoppingCart = new ShoppingCart();
    }

    public boolean isExist() {
        return this.user.userType.equals("Buyer");
    }

    public void buyProduct(Product product) throws ProductNotFoundExc {
        this.shoppingCart.removePurchase(product);
        product.addAmount(-1);
    }
}
