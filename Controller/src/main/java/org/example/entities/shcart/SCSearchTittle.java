package org.example.entities.shcart;

import org.example.entities.product.Product;
import org.example.entities.product.ProductSearch;

import java.util.ArrayList;
import java.util.Map;

public class SCSearchTittle {
    private final ShoppingCart shoppingCart;

    private ArrayList<Product> foundProducts;

    public SCSearchTittle(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList<Product> searchByTittle(String title) {
        this.foundProducts = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry: this.shoppingCart.purchases.entrySet()) {
            if (new ProductSearch(entry.getKey()).isFindTittle(title)) {
                this.foundProducts.add(entry.getKey());
            }
        }
        if (this.foundProducts.size() != 0) {
            return this.foundProducts;
        } else {
            //change exception
        }
        return null;
    }
}
