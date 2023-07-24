package org.example.entities.product;

public class ProductCategorySpecifications {
    private final boolean hasParent;
    private final boolean hasChild;
    private final String name;

    public ProductCategorySpecifications(boolean hasParent, boolean hasChild, String name) {
        this.hasParent = hasParent;
        this.hasChild = hasChild;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public boolean isRoot() {
        return hasParent;
    }

    public boolean isLeaf() {
        return hasChild;
    }
}
