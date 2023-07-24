package org.example.validation.exceptions;

public class MinNameExc extends Exception {
    @Override
    public String toString() {
        return "Name must consist of at least 3 characters.";
    }
}
