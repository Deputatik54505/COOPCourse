package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private final IQuery query;
    private final int id;
    public ProductData data;

    public Product(int id) {
        this.id = id;
        query = new Query();
    }


    public void load() {
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT * FROM product WHERE id=%d;", id))) {
            if (resultSet.next()) {
                var price = resultSet.getFloat("price");
                var name = resultSet.getString("name");
                var description = resultSet.getString("description");
                var available = resultSet.getInt(6);
                data = new ProductData(name, description, price, available);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete() {
        query.executeWithoutResponse(
                String.format("delete from product where id=%d", this.id));

    }

    /**
     * Increases or decreases number of available products
     *
     * @param numberOfProducts positive or negative integer
     *                         which is representing number of added amount of products.
     */
    public void addAmount(int numberOfProducts) {
        if (numberOfProducts == 0)
            throw new IllegalArgumentException("It is impossible to add 0 products");
        if (!data.isAvailable(-numberOfProducts))
            throw new IllegalArgumentException(String.format(
                    "Current amount of products is less then %d", numberOfProducts));

        var currentData = data.represent();
        var available = Integer.parseInt(currentData.get(3)) + numberOfProducts;
        this.data = new ProductData(currentData.get(0),
                currentData.get(1),
                Float.parseFloat(currentData.get(2)),
                available);
        query.executeWithoutResponse(
                String.format("update product set available=%d where id=%d;", available, id));

    }

    public void editPrice(float price) {
        var currentData = data.represent();
        this.data = new ProductData(currentData.get(0),
                currentData.get(1),
                price,
                Integer.parseInt(currentData.get(3)));
        query.executeWithoutResponse(
                String.format("update product set price=%f where id=%d;", price, id));
    }

    public void editDescription(String description) {
        var currentData = data.represent();
        this.data = new ProductData(currentData.get(0),
                description,
                Float.parseFloat(currentData.get(2)),
                Integer.parseInt(currentData.get(3)));
        query.executeWithoutResponse(
                String.format("update product set description=%s where id=%d;", description, id));
    }

}
