package org.example.entities.buyer;

import org.example.entities.product.Product;

public class BuyerFGlobal {
    private final Buyer buyer;

    public BuyerFGlobal(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product findGlobal(Product neededProduct) {
        return this.buyer.productList.searchProduct(neededProduct);
    }
}
