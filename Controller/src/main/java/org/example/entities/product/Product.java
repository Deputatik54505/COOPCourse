package org.example.entities.product;

//import java.sql.ResultSet;
//import java.sql.SQLException;

public class Product {
    private ProductPrice price;
    private String name;
    private String description;
    private int id;

    private ProductConnector productConnector;

//    public void loadById(int id) {
//        try (ResultSet resultSet = executeQuery(String.format("SELECT * FROM Product WHERE id=%d", id))) {
//            if (resultSet.next()) {
//                price = new ProductPrice(resultSet.getFloat("price"));
//                name = resultSet.getString("name");
//                description = resultSet.getString("description");
//                this.id = id;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private ResultSet executeQuery(String query) {
//        if (productConnector == null)
//            productConnector = new ProductConnector();
//
//        var dataSource = productConnector.dataSource();
//        ResultSet resultSet;
//        try (var connection = dataSource.getConnection();
//             var useStatement = connection.prepareStatement("use crm;");
//             var queryStatement = connection.prepareStatement(query)) {
//
//            useStatement.execute();
//            resultSet = queryStatement.executeQuery();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return resultSet;
//    }

}
