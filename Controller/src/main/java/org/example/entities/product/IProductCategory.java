package org.example.entities.product;

public abstract class IProductCategory {
    public IProductCategorySpecifications specifications;
    public IProductCategoryHierarchy hierarchy;

    public abstract void loadById();
}
