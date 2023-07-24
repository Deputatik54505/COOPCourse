package org.example.validation.exceptions;

public class MinPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain minimum 8 characters";
    }
}
