package org.example.entities.buyer;

import org.example.database.Query;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.product.Product;
import org.example.entities.user.User;
import org.example.validation.exceptions.ProductNotFoundExc;

import java.sql.SQLException;

public class Buyer {
    public final User user;
    public final ShoppingCart shoppingCart;

    public Buyer(User user) {
        this.user = user;
        int buyerId;
        Query query = new Query();
        try (var resultSet = query.executeQuery(String.format("select id from customer " +
                "where \"userId\" in (SELECT id from \"userTable\" where email='%s');\n", user.getEmail()))) {
            buyerId = resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.shoppingCart = new ShoppingCart(buyerId);
        shoppingCart.load();
    }


    public void buyProduct(Product product) throws ProductNotFoundExc {
        this.shoppingCart.removePurchase(product);
        product.addAmount(-1);
    }
}
