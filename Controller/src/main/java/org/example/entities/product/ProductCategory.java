package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProductCategory extends IProductCategory {
    private final IQuery query;
    private final int id;
    public IProductCategoryHierarchy hierarchy;
    public IProductCategorySpecifications specifications;

    public ProductCategory(int id) {
        this.id = id;
        query = new Query();
    }

    public void loadById() {
        try (var resultSet = query.executeQuery(String.format("SELECT * FROM Category WHERE id=%d", id))) {

            if (!resultSet.next())
                throw new IllegalArgumentException("Id is not exists in database");
            var name = resultSet.getString("name");

            int superCategoryId = resultSet.getInt("parentId");
            var children = resultSet.getString("childrenIds");
            List<Integer> childIds = null;
            if (children != null && !children.trim().isEmpty()) {
                childIds = Arrays.stream(children
                                .split("\\."))
                        .map(Integer::parseInt)
                        .toList();
            }

            hierarchy = new ProductCategoryHierarchy(childIds, superCategoryId);
            specifications = new ProductCategorySpecification(superCategoryId == 0,
                    childIds == null,
                    name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
