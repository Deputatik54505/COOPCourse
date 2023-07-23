package org.example.validation.exceptions;

public class NumPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain digit.";
    }
}
