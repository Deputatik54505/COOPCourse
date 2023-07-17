package org.example.entities.cart;

import org.example.entities.product.Product;
import org.example.validation.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    protected final Map<Product, Integer> purchases;

    public ShoppingCart() {
        this.purchases = new HashMap<>();
    }

    public void addPurchase(Product newPurchase) {
        if (this.purchases.containsKey(newPurchase)) {
            this.purchases.put(newPurchase, this.purchases.get(newPurchase) + 1);
        } else {
            this.purchases.put(newPurchase, 1);
        }
    }

    public void removePurchase(Product remPurchase) throws NotFoundException {
        if (!this.purchases.containsKey(remPurchase)) {
            throw new NotFoundException();
        }
        this.purchases.put(remPurchase, this.purchases.get(remPurchase) - 1);
        if (this.purchases.get(remPurchase) == 0) {
            this.purchases.remove(remPurchase);
        }
    }

    public Product searchPurchase(Product neededPurchase) throws NotFoundException {
        for (Map.Entry<Product, Integer> entry: this.purchases.entrySet()) {
            if (entry.getKey().equals(neededPurchase)) {
                return entry.getKey();
            }
        }
        throw new NotFoundException();
    }
}
