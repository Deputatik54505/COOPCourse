package org.example.entities.seller;

import org.example.database.Query;
import org.example.entities.product.Product;
import org.example.entities.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class Seller {
    private final User user;

    public Seller(User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }

    public ArrayList<Product> goods() {
        Query query = new Query();
        ArrayList<Product> goods = new ArrayList<>();
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT goods FROM distributor WHERE \"userId\" " +
                        "in (SELECT id from \"userTable\" where email='%s');\n", user.data().email()))) {
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
