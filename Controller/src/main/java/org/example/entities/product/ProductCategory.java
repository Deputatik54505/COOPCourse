package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProductCategory implements IProductCategory {
    private final IQuery query;
    private int id;
    private String name;
    private List<Integer> directSubcategories;
    private Integer superCategoryId;

    public ProductCategory(int id, String name, List<Integer> directSubcategories, Integer superCategory) {
        this.id = id;
        this.name = name;
        this.directSubcategories = directSubcategories == null ? new ArrayList<>() : directSubcategories;
        this.superCategoryId = superCategory;
        query = new Query();
    }

    public ProductCategory() {
        query = new Query();
    }

    @Override
    public Collection<IProductCategory> directSubcategories() {
        Collection<IProductCategory> collection = new ArrayList<>(directSubcategories.size());
        for (var z : directSubcategories) {
            collection.add(loadById(z));
        }
        return collection;
    }

    @Override
    public Collection<Integer> allSubcategoryIds() {
        Collection<Integer> ids = new ArrayList<>();
        ids.add(id);
        if (directSubcategories == null)
            return null;
        for (var z : directSubcategories()) {
            if (!z.isLeafCategory())
                continue;
            ids.addAll(z.allSubcategoryIds());
        }
        return ids;
    }

    @Override
    public IProductCategory superCategory() {
        return loadById(superCategoryId);
    }

    @Override
    public boolean isRootCategory() {
        return superCategoryId == null;
    }

    @Override
    public boolean isLeafCategory() {
        return directSubcategories == null;
    }

    public IProductCategory loadById(int id) {
        try (var resultSet = query.executeQuery(String.format("SELECT * FROM Category WHERE id=%d", id))) {
            if (!resultSet.next())
                throw new IllegalArgumentException("Id is not exists in database");
            String name = resultSet.getString("name");
            Integer superId = resultSet.getInt("parentId");
            var children = resultSet.getString("childrenIds");
            List<Integer> childIds = new ArrayList<>();
            if (children != null) {
                childIds = Arrays.stream(children
                                .split("\\."))
                        .map(Integer::parseInt)
                        .toList();
            }
            return new ProductCategory(id, name, childIds, superId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
