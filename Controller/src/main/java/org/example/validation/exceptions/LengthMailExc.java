package org.example.validation.exceptions;

public class LengthMailExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect mail length.";
    }
}
