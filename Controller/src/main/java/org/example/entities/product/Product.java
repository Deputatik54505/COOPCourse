package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private final IQuery query;
    private final int id;
    protected String name;
    protected String description;
    private float price;

    public Product(int id) {
        this.id = id;
        query = new Query();
    }

    public void loadById() {
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT * FROM product WHERE id=%d;", id))) {
            if (resultSet.next()) {
                price = resultSet.getFloat("price");
                name = resultSet.getString("name");
                description = resultSet.getString("description");
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
        this.price = price;
        try (var resultSet = query.executeQuery(
                String.format("update product set price=%f where id=%d;", price, id))) {
            return resultSet.isLast();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean editDescription(String description) {
        this.description = description;
        try (var resultSet = query.executeQuery(
                String.format("update product set description=%s where id=%d;", description, id))) {
            return resultSet.isLast();
        } catch (SQLException e) {
            return false;
        }
    }
}
