package org.example.entities.product;

import java.awt.color.ProfileDataException;

class ProductPrice {
    private double price;

    public ProductPrice(float price) {
        this.price = price;
    }

    public double calculateCost(int quantity) {
        if (price == 0) {
           throw new ProfileDataException("price is not defined");
        }
        return price * quantity;
    }

    public void changePriceBy(float increment) {
        if (-increment >= price) {
            throw new IllegalArgumentException("price should not be negative");
        }
        price += increment;
    }

}
