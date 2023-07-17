package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.user.User;
import org.example.validation.exceptions.NotFoundException;

public class Buyer extends User {
    protected final ShoppingCart shoppingCart;

    public Buyer(String mail, String password) {
        super(mail, password);
        this.shoppingCart = new ShoppingCart();
    }

    public void buyProduct(Product product) throws NotFoundException {
        this.shoppingCart.removePurchase(product);
        //TODO remove the product from BD
    }
}
