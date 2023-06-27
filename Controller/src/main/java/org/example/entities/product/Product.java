package org.example.entities.product;

public class Product {
    private ProductPrice price;
    private String name;
    private String description;
    private int id;

    private Product() {

    }

    public Product readProductByQuery(String query) {
        //todo: read product from db;

        price = new ProductPrice(0);
        name = "";
        description = "";
        id = 14;


        return this;
    }



    //todo: think how to use this class if not like a storage of data

}
