package org.example.validation.exceptions;

public class LengthPassportExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect passport length.";
    }
}
