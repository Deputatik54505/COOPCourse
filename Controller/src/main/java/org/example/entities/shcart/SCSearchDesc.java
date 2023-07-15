package org.example.entities.shcart;

import org.example.entities.product.Product;
import org.example.entities.product.ProductSearch;

import java.util.ArrayList;
import java.util.Map;

public class SCSearchDesc {
    private final ShoppingCart shoppingCart;

    private ArrayList<Product> foundProducts;

    public SCSearchDesc(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList<Product> searchByDesc(String desc) {
        this.foundProducts = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry: this.shoppingCart.purchases.entrySet()) {
            if (new ProductSearch(entry.getKey()).isFindDesc(desc)) {
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
