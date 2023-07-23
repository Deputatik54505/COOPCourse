package org.example.validation.exceptions;

public class LowPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain lowercase character.";
    }
}
