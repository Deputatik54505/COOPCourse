package org.example.entities.product;

import org.example.database.IQuery;
import org.example.database.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Product {
    private final IQuery query;
    protected String name;
    protected String description;
    private float price;
    private int id;
    private IProductCategory category;

    public Product() {
        query = new Query();
        category = new ProductCategory();
    }

    public void loadById(int id) {
        try (ResultSet resultSet = query.executeQuery(
                String.format("SELECT * FROM product WHERE id=%d;", id))) {
            if (resultSet.next()) {
                price = resultSet.getFloat("price");
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

    public Collection<Product> getProducts() {
        Collection<Product> products = new ArrayList<>();
        try (ResultSet resultSet = query.executeQuery("SELECT * FROM product")) {
            while (resultSet.next()) {
                var product = new Product();
                product.price = resultSet.getFloat("price");
                product.name = resultSet.getString("name");
                product.description = resultSet.getString("description");
                var categoryId = resultSet.getInt("categoryId");
                product.category = category.loadById(categoryId);
                product.id = resultSet.getInt("id");
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
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

//    public boolean editCategory(IProductCategory category) {
//        this.category = category;
//        try (var resultSet = query.executeQuery(
//                String.format("update product set categoryId=%d where id=%d;", category., id))) {
//            return true;
//        } catch (SQLException e) {
//            return false;
//        }
//    }

}
