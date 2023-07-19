package org.example.entities.product;

import org.example.database.Connector;
import org.example.database.IConnector;
import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private ProductPrice price;
    protected String name;
    protected String description;
    private int id;
    private IProductCategory category;
    private final IQuery query;
    public Product(){
        query = new Query();
        category = new ProductCategory();
    }

    public void loadById(int id) {
        try (ResultSet resultSet = query.executeQuery(String.format("SELECT * FROM Product WHERE id=%d", id))) {
            if (resultSet.next()) {
                price = new ProductPrice(resultSet.getFloat("price"));
                name = resultSet.getString("name");
                description = resultSet.getString("description");
                var categoryId = resultSet.getInt("categoryId");
                category = category.loadById(categoryId);
                this.id = id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
