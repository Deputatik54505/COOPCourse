package org.example.entities.product;

public class ProductSearch {
    protected int start;

    public ProductSearch() {
        this.start = 0;
    }

    public boolean isFindChar(String str, char ch, int begin) {
        for (int i = begin; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                this.start = i + 1;
                return true;
            }
        }
        return false;
    }
}
