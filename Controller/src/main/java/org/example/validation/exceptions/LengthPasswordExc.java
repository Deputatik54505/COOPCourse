package org.example.validation.exceptions;

public class LengthPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect password length.";
    }
}
