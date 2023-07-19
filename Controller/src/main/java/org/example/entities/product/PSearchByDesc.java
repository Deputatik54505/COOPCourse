package org.example.entities.product;

public class PSearchByDesc extends ProductSearch {
    private final Product product;

    public PSearchByDesc(Product product) {
        this.product = product;
    }

    public boolean isFindDesc(String description) {
        this.start = 0;
        for (int i = 0; i < description.length(); i++) {
            if (!this.isFindChar(this.product.description, description.charAt(i), this.start)) {
                return false;
            }
        }
        return true;
    }
}
