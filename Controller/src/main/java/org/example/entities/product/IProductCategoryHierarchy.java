package org.example.entities.product;

import java.util.Collection;

public interface IProductCategoryHierarchy {
    Collection<IProductCategory> directSubcategories();
    Collection<Integer> allSubcategoryIds();

    IProductCategory superCategory();
}
