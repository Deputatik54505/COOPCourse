package org.example.entities.product;

import java.util.Collection;

public interface IProductCategory {
    Collection<IProductCategory> directSubcategories();
    Collection<Integer> allSubcategoryIds();

    IProductCategory superCategory();
    IProductCategory loadById(int id);
    boolean isRootCategory();

    boolean isLeafCategory();
}
