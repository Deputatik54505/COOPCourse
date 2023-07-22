package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ProductCategory extends IProductCategory {
    private final IQuery query;
    private final int id;

    public ProductCategory(int id) {
        this.id = id;
        query = new Query();
    }

    public void load() {
        try (var resultSet = query.executeQuery(String.format("SELECT * FROM Category WHERE id=%d", id))) {

            if (!resultSet.next())
                throw new IllegalArgumentException("Id is not exists in database");
            var name = resultSet.getString("name");

            int superCategoryId = resultSet.getInt("parentId");
            var children = resultSet.getString("childrenIds");
            List<Integer> childIds = null;
            if (children != null && !children.trim().isEmpty()) {
                childIds = Arrays.stream(children
                                .split(","))
                        .map(Integer::parseInt)
                        .toList();
            }

            this.hierarchy = new ProductCategoryHierarchy(childIds, superCategoryId == 0 ? null : superCategoryId);
            this.specifications = new ProductCategorySpecification(superCategoryId != 0,
                    childIds != null,
                    name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Product> getProducts() {
        var ids = hierarchy.allSubcategoryIds();
        StringBuilder queryBuilder = new StringBuilder("SELECT id FROM Product WHERE \"categoryId\" in (");
        for (int id : ids){
            queryBuilder.append(id);
            queryBuilder.append(",");
        }
        queryBuilder.deleteCharAt(queryBuilder.lastIndexOf(","));
        queryBuilder.append(");");

        Collection<Product> products = new ArrayList<>();
        try (var resultSet = query.executeQuery(queryBuilder.toString())){
            while (resultSet.next()){
                var product = new Product(resultSet.getInt("id"));
                product.load();
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


}
