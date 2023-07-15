package org.example.entities.buyer;

import org.example.entities.product.Product;

public class BuyerRemove {
    private final Buyer buyer;

    public BuyerRemove(Buyer buyer) {
        this.buyer = buyer;
    }

    public void removeFromCart(Product product) {
        this.buyer.shoppingCart.removePurchase(product);
    }
}
