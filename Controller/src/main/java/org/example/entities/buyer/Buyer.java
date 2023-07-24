package org.example.entities.buyer;

import org.example.database.Query;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.product.Product;
import org.example.entities.user.User;
import org.example.validation.exceptions.ProductNotFoundExc;

import java.sql.SQLException;

public class Buyer {
    public final User user;
    public ShoppingCart shoppingCart;

    public Buyer(User user) {
        this.user = user;
        shoppingCart = new ShoppingCart();
    }

    public Buyer loadBuyer(User user) {

        Buyer buyer = new Buyer(user);
        int buyerId;
        Query query = new Query();
        try (var resultSet = query.executeQuery(String.format("select id from customer " +
                "where \"userId\" in (SELECT id from \"userTable\" where email='%s');", user.email()))) {
            buyerId = resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        buyer.shoppingCart.load(buyerId);
        return buyer;
    }


    public void buyProduct(Product product) throws ProductNotFoundExc {
        this.shoppingCart.removePurchase(product);
        product.addAmount(-1);
    }
}
