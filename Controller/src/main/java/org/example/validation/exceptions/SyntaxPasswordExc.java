package org.example.validation.exceptions;

public final class SyntaxPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password contains forbidden characters.";
    }
}
