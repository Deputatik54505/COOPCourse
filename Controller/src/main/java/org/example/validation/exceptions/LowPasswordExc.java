package org.example.validation.exceptions;

public final class LowPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain lowercase character.";
    }
}
