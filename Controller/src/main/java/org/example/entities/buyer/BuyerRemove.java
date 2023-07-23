package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.validation.exceptions.ProductNotFoundExc;

public class BuyerRemove {
    private final Buyer buyer;

    public BuyerRemove(Buyer buyer) {
        this.buyer = buyer;
    }

    public void removeFromCart(Product product) throws ProductNotFoundExc {
        this.buyer.shoppingCart.removePurchase(product);
    }
}
