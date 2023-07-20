package org.example.tables;

import org.example.entities.product.Product;
import org.example.validation.exceptions.NotFoundException;

import java.util.ArrayList;

public class ProductsMain {
    private final ArrayList<Product> products;

    public ProductsMain() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product newProduct) {
        this.products.add(newProduct);
    }

    public void removeProduct(Product remProduct) {
        this.products.remove(remProduct);
    }

    public ArrayList<Product> loadProducts() throws NotFoundException {
        if (this.products.isEmpty()) {
            throw new NotFoundException();
        }
        return this.products;
    }
}
