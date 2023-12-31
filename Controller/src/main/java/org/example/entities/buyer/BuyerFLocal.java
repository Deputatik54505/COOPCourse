package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.validation.exceptions.ProductNotFoundExc;

public final class BuyerFLocal {
    private final Buyer buyer;

    public BuyerFLocal(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product findLocal(Product neededPurchase) throws ProductNotFoundExc {
        try {
            return this.buyer.cart().searchPurchase(neededPurchase);
        } catch (Exception e) {
            throw e;
        }

    }
}
