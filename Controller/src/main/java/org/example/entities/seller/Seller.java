package org.example.entities.seller;

import org.example.database.IQuery;
import org.example.database.Query;
import org.example.entities.cart.ShoppingCart;
import org.example.entities.product.Product;
import org.example.entities.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Seller {
    public final User user;
    public final ShoppingCart shoppingCart;
    private IQuery query;

    public Seller(User user) {
        this.user = user;
        shoppingCart = new ShoppingCart();

    }

    public Seller loadSeller(User user) {
        Seller seller = new Seller(user);
        int sellerId;
        query = new Query();
        try (var resultSet = query.executeQuery(String.format("select id from distributor " +
                "where \"userId\" in (SELECT id from \"userTable\" where email='%s');\n", user.email()))) {
            sellerId = resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        seller.shoppingCart.load(sellerId);

        return seller;
    }


    // TODO DOES NOT WORK
    public ArrayList<Product> goods() {
        ArrayList<Product> goods = new ArrayList<>();
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT goods FROM distributor WHERE id=%d"))) {
            if (resultSet.next()) {
                String products = resultSet.getString("goods");
                if (products != null && !products.trim().isEmpty()) {
                    var purchasesList = Arrays.stream(products.split(","))
                            .map(Integer::parseInt).toList();
                    for (var productId : purchasesList) {
                        var product = new Product(productId);
                        product.load();
                        goods.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

}
