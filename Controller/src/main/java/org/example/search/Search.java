package org.example.search;

import org.example.entities.product.PSearchByDesc;
import org.example.entities.product.PSearchByTittle;
import org.example.entities.product.Product;
import org.example.entities.product.ProductSearch;
import org.example.tables.ProductsMain;
import org.example.validation.exceptions.NotFoundException;

import java.util.ArrayList;

public class Search {
    private final ProductsMain productsMain;

    private final ArrayList<Product> foundProducts;

    private ArrayList<Product> products;

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
            if (new PSearchByTittle(value).isFindTittle(str) ||
                    new PSearchByDesc(value).isFindDesc(str)) {
                this.foundProducts.add(value);
            }
        }
        if (this.foundProducts.size() == 0) {
            throw new NotFoundException();
        }
        return this.foundProducts;
    }
}
