package org.example.validation.exceptions;

public final class MaxNameExc extends Exception {
    @Override
    public String toString() {
        return "Name must consist of maximum 20 characters.";
    }
}
