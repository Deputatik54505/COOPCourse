package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ProductCategory {
    private final IQuery query;
    private final int id;
    private ProductCategoryHierarchy hierarchy;
    private ProductCategorySpecifications specifications;

    public ProductCategory(int id) {
        this.id = id;
        query = new Query();
    }

    public ProductCategorySpecifications specifications() {
        return specifications;
    }

    public ProductCategoryHierarchy hierarchy() {
        return hierarchy;
    }

    public void load() {
        try (var resultSet = query.executeQuery(String.format("SELECT * FROM Category WHERE id=%d", id))) {
            if (!resultSet.next())
                throw new IllegalArgumentException("Id is not exists in database");
            var name = resultSet.getString("name");

            int superCategoryId = resultSet.getInt("parentId");
            var children = resultSet.getString("childrenIds");
            List<Integer> childIds = new ArrayList<>();
            if (children != null && !children.trim().isEmpty()) {
                childIds = Arrays.stream(children
                                .split(","))
                        .map(Integer::parseInt)
                        .toList();
            }

            this.hierarchy = new ProductCategoryHierarchy(childIds, superCategoryId);
            this.specifications = new ProductCategorySpecifications(superCategoryId != 0,
                    childIds.size() != 0,
                    name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Product> getProducts() {
        var categories = hierarchy.subcategories();
        categories.add(this);
        StringBuilder queryBuilder = new StringBuilder("SELECT id FROM Product WHERE \"categoryId\" in (");
        for (var category : categories) {
            queryBuilder.append(category.id);
            queryBuilder.append(",");
        }
        queryBuilder.deleteCharAt(queryBuilder.lastIndexOf(","));
        queryBuilder.append(");");

        Collection<Product> products = new ArrayList<>();
        try (var resultSet = query.executeQuery(queryBuilder.toString())) {
            while (resultSet.next()) {
                int prid = resultSet.getInt("id");
                var product = new Product(prid);
                product.load();
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


}
