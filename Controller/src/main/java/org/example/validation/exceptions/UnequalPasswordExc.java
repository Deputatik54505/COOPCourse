package org.example.validation.exceptions;

public final class UnequalPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Passwords don't match.";
    }
}
