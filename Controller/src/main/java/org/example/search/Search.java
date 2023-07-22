package org.example.search;

import org.example.entities.product.Product;
import org.example.tables.ProductsMain;
import org.example.validation.exceptions.NotFoundException;

import java.util.ArrayList;

public class Search {
    private final ProductsMain productsMain;

    private final ArrayList<Product> foundProducts;

    private ArrayList<Product> products;

    private Product product;

    public Search() {
        this.foundProducts = new ArrayList<>();
        this.productsMain = new ProductsMain();
        this.products = new ArrayList<>();
    }

    public void initSearch() throws NotFoundException {
        this.products = this.productsMain.loadProducts();
    }

    public ArrayList<Product> search(String str) throws NotFoundException {
        for (Product value : this.products) {
            this.product = value;
            if (product.data.hasWord(str)) {
                this.foundProducts.add(this.product);
            }
        }
        if (this.foundProducts.size() == 0) {
            throw new NotFoundException();
        }
        return this.foundProducts;
    }
}
