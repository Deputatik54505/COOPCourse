package org.example.validation.exceptions;

public class MaxPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain maximum 24 characters";
    }
}
