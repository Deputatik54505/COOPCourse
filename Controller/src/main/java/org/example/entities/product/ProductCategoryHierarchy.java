package org.example.entities.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductCategoryHierarchy implements IProductCategoryHierarchy {
    private final List<Integer> directSubcategories;
    private final Integer superCategoryId;

    public ProductCategoryHierarchy(List<Integer> directSubcategories, Integer superCategoryId) {
        this.directSubcategories = directSubcategories;
        this.superCategoryId = superCategoryId;
    }

    @Override
    public Collection<IProductCategory> directSubcategories() {
        Collection<IProductCategory> collection = new ArrayList<>(directSubcategories.size());
        for (var categoryId : directSubcategories) {
            var category = new ProductCategory(categoryId);
            category.load();
            collection.add(category);
        }
        return collection;
    }

    @Override
    public Collection<Integer> allSubcategoryIds() {
        Collection<Integer> ids = new ArrayList<>();
        if (directSubcategories == null)
            return null;
        for (var category : directSubcategories()) {
            if (!category.specifications.isLeafCategory())
                continue;
            ids.addAll(category.hierarchy.allSubcategoryIds());
        }
        return ids;

    }

    @Override
    public IProductCategory superCategory() {
        if (superCategoryId == null)
            return null;
        var category = new ProductCategory(superCategoryId);
        category.load();
        return category;
    }
}
