package org.example.entities.buyer;

import org.example.entities.product.Product;

public class BuyerAdd {
    private final Buyer buyer;

    public BuyerAdd(Buyer buyer) {
        this.buyer = buyer;
    }

    public void addToCart(Product product) {
        this.buyer.cart().addPurchase(product);
    }
}
