package org.example.entities.product;

import java.util.HashMap;
import java.util.Map;

public class ProductList {
    private final Map<Product, Integer> products;

    public ProductList() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product newProduct) {
        if (this.products.containsKey(newProduct)) {
            this.products.put(newProduct, this.products.get(newProduct) + 1);
        } else {
            this.products.put(newProduct, 1);
        }
    }

    public void removeProduct(Product remProduct) {
        if (!this.products.containsKey(remProduct)) {
            // throw exception
        }
        this.products.put(remProduct, this.products.get(remProduct) - 1);
        if (this.products.get(remProduct) == 0) {
            //TODO уведомить продавца
            this.products.remove(remProduct);
        }
    }

    public Product searchProduct(Product neededProduct) {
        for (Map.Entry<Product, Integer> entry: this.products.entrySet()) {
            if (entry.getKey().equals(neededProduct)) {
                return entry.getKey();
            }
        }
        throw new SecurityException(); //change exception
    }
}
