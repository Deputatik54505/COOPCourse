package org.example.entities.product;

public abstract class IProductCategory {
    IProductCategorySpecifications specifications;
    IProductCategoryHierarchy hierarchy;

    public abstract void loadById();
}
