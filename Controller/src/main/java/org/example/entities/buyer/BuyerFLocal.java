package org.example.entities.buyer;

import org.example.entities.product.Product;

public class BuyerFLocal {
    private final Buyer buyer;

    public BuyerFLocal(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product findLocal(Product neededPurchase) {
        return this.buyer.shoppingCart.searchPurchase(neededPurchase);
    }
}
