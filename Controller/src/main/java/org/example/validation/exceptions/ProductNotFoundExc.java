package org.example.validation.exceptions;

public class ProductNotFoundExc extends Exception {
    @Override
    public String toString() {
        return "Product does not exist.";
    }
}
