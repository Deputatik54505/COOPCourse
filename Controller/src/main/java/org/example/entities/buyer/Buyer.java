package org.example.entities.buyer;

import org.example.entities.product.Product;
import org.example.entities.product.ProductList;
import org.example.entities.shcart.ShoppingCart;

public class Buyer {
    protected final ShoppingCart shoppingCart;

    protected final ProductList productList;

    public Buyer(ProductList productList) {
        this.shoppingCart = new ShoppingCart();
        this.productList = productList;
    }

    public void buyProduct(Product product) {
        this.shoppingCart.removePurchase(product);
        this.productList.removeProduct(product);
    }
}
