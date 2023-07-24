package org.example.entities.cart;

import org.example.database.Query;
import org.example.entities.product.Product;
import org.example.validation.exceptions.ProductNotFoundExc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> purchases;

    public ShoppingCart() {
        this.purchases = new HashMap<>();
    }

    public void load(int userId) {
        Query query = new Query();

        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT cart FROM customer WHERE userId=%d", userId))) {
            if (resultSet.next()) {
                String products = resultSet.getString("cart");
                if (products != null && !products.trim().isEmpty()) {
                    var purchasesList = Arrays.stream(products.split(","))
                            .map(Integer::parseInt).toList();
                    for (var productId : purchasesList) {
                        var product = new Product(productId);
                        product.load();
                        if (purchases.containsKey(product)) {
                            purchases.replace(product, purchases.get(product) + 1);
                        } else
                            purchases.put(product, 1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPurchase(Product newPurchase) {
        if (this.purchases.containsKey(newPurchase)) {
            this.purchases.put(newPurchase, this.purchases.get(newPurchase) + 1);
        } else {
            this.purchases.put(newPurchase, 1);
        }
    }

    public void removePurchase(Product remPurchase) throws ProductNotFoundExc {
        if (!this.purchases.containsKey(remPurchase)) {
            throw new ProductNotFoundExc();
        }
        this.purchases.put(remPurchase, this.purchases.get(remPurchase) - 1);
        if (this.purchases.get(remPurchase) == 0) {
            this.purchases.remove(remPurchase);
        }
    }

    public Product searchPurchase(Product neededPurchase) throws ProductNotFoundExc {
        for (Map.Entry<Product, Integer> entry : this.purchases.entrySet()) {
            if (entry.getKey().equals(neededPurchase)) {
                return entry.getKey();
            }
        }
        throw new ProductNotFoundExc();
    }
}
