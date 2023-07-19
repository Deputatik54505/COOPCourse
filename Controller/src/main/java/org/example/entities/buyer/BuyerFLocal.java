package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.validation.exceptions.NotFoundException;

public class BuyerFLocal {
    private final Buyer buyer;

    public BuyerFLocal(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product findLocal(Product neededPurchase) throws NotFoundException {
        return this.buyer.shoppingCart.searchPurchase(neededPurchase);
    }
}
