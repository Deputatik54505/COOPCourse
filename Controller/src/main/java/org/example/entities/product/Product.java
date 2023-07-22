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


    public void loadById() {
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT * FROM product WHERE id=%d;", id))) {
            if (resultSet.next()) {
                var price = resultSet.getFloat("price");
                var name = resultSet.getString("name");
                var description = resultSet.getString("description");

                data = new ProductData(name, description, price);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean delete() {
        try (ResultSet resultSet = query.executeQuery(
                String.format("delete from product where id=%d", this.id))) {
            return resultSet.isLast();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editPrice(float price) {
        this.data = new ProductData(data.represent().get(0), data.represent().get(1), price);
        try (var resultSet = query.executeQuery(
                String.format("update product set price=%f where id=%d;", price, id))) {
            return resultSet.isLast();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editDescription(String description) {
        this.data = new ProductData(data.represent().get(0), description,
                Float.parseFloat(data.represent().get(2)));
        try (var resultSet = query.executeQuery(
                String.format("update product set description=%s where id=%d;", description, id))) {
            return resultSet.isLast();
        } catch (SQLException e) {
            return false;
        }
    }

}
