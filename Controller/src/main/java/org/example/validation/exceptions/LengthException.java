package org.example.validation.exceptions;

public class LengthException extends Exception {
    @Override
    public String toString() {
        return "Incorrect length!";
    }
}
