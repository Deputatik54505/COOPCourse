package org.example.entities.buyer;

import org.example.database.Query;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.product.Product;
import org.example.entities.user.User;

import java.sql.SQLException;

public final class Buyer {
    private final User user;
    private final ShoppingCart shoppingCart;

    public Buyer(User user) {
        this.user = user;
        shoppingCart = new ShoppingCart();
    }

    public Buyer loadBuyer(User user) {

        Buyer buyer = new Buyer(user);
        int buyerId;
        Query query = new Query();
        try (var resultSet = query.executeQuery(String.format("select id from customer " +
                "where \"userId\" in (SELECT id from \"userTable\" where email='%s');", user.data().email()))) {
            buyerId = resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        buyer.shoppingCart.load(buyerId);
        return buyer;
    }


    public void buyProduct(Product product) {
        this.shoppingCart.removePurchase(product);
        product.addAmount(-1);
    }

    public User user() {
        return user;
    }

    public ShoppingCart cart() {
        return shoppingCart;
    }
}
