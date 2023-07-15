package org.example.entities.product;

public class ProductSearch {
    private final Product product;
    
    private int start;

    public ProductSearch(Product product) {
        this.product = product;
    }

    public boolean isFindTittle(String name) {
        this.start = 0;
        for (int i = 0; i < name.length(); i++) {
            if (!this.isFindChar(this.product.name, name.charAt(i), this.start)) {
                return false;
            }
        }
        return true;
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

    private boolean isFindChar(String str, char ch, int begin) {
        for (int i = begin; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                this.start = i + 1;
                return true;
            }
        }
        return false;
    }
}
