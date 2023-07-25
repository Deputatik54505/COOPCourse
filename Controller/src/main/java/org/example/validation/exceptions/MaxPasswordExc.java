package org.example.validation.exceptions;

public final class MaxPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain maximum 24 characters";
    }
}
