package org.example.entities.product;

public class ProductCategorySpecification implements IProductCategorySpecifications {
    private final boolean hasParent;
    private final boolean hasChild;
    private final String name;

    public ProductCategorySpecification(boolean hasParent, boolean hasChild, String name) {
        this.hasParent = hasParent;
        this.hasChild = hasChild;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isRootCategory() {
        return hasParent;
    }

    @Override
    public boolean isLeafCategory() {
        return hasChild;
    }
}
