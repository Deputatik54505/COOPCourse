package org.example.entities.product;

public class PSearchByTittle extends ProductSearch {
    private final Product product;

    public PSearchByTittle(Product product) {
        this.product = product;
    }

    public boolean isFindTittle(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (!this.isFindChar(this.product.name, name.charAt(i), this.start)) {
                return false;
            }
        }
        return true;
    }
}
