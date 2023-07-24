package org.example.search;

import org.example.entities.product.Product;
import org.example.entities.product.ProductCategory;
import org.example.validation.exceptions.ProductNotFoundExc;

import java.util.ArrayList;
import java.util.Collection;

public class Search {

    private final ProductCategory productCategory;
    private Collection<Product> products;

    public Search() {
        this.products = new ArrayList<>();
        productCategory = new ProductCategory(1);
    }

    public void initSearch() {
        this.products = productCategory.getProducts();
    }

    public ArrayList<Product> search(String str) throws ProductNotFoundExc {
        var suitableProducts = new ArrayList<Product>();
        for (Product value : this.products) {
            if (value.data().hasWord(str)) {
                suitableProducts.add(value);
            }
        }
        if (suitableProducts.size() == 0) {
            throw new ProductNotFoundExc();
        }
        return suitableProducts;
    }
}
