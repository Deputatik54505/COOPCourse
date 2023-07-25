package org.example.validation.exceptions;

public final class LengthPassportExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect passport length.";
    }
}
