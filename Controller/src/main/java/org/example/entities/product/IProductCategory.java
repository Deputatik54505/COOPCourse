package org.example.entities.product;

import java.util.Collection;

public abstract class IProductCategory {
    protected int id;
    public IProductCategorySpecifications specifications;
    public IProductCategoryHierarchy hierarchy;

    public abstract void load();
    public abstract Collection<Product> getProducts();
}
