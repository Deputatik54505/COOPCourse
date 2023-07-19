package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.validation.exceptions.NotFoundException;

public class BuyerRemove {
    private final Buyer buyer;

    public BuyerRemove(Buyer buyer) {
        this.buyer = buyer;
    }

    public void removeFromCart(Product product) throws NotFoundException {
        this.buyer.shoppingCart.removePurchase(product);
    }
}
