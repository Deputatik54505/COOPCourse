package org.example.entities.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductCategoryHierarchy {
    private final List<Integer> directSubcategories;
    private final Integer superCategoryId;

    public ProductCategoryHierarchy(List<Integer> directSubcategories, Integer superCategoryId) {
        this.directSubcategories = directSubcategories;
        this.superCategoryId = superCategoryId;
    }

    public Collection<ProductCategory> child() {
        Collection<ProductCategory> collection = new ArrayList<>(directSubcategories.size());
        for (var categoryId : directSubcategories) {
            var category = new ProductCategory(categoryId);
            category.load();
            collection.add(category);
        }
        return collection;
    }

    public Collection<ProductCategory> subcategories() {
        Collection<ProductCategory> ids = new ArrayList<>();
        if (directSubcategories == null)
            return ids;
        for (var category : child()) {
            ids.add(category);
            if (!category.specifications().isLeaf())
                continue;

            ids.addAll(category.hierarchy().subcategories());
        }
        return ids;
    }

    public ProductCategory superCategory() {
        if (superCategoryId == null)
            throw new RuntimeException("this is root category");
        var category = new ProductCategory(superCategoryId);
        category.load();
        return category;
    }
}
