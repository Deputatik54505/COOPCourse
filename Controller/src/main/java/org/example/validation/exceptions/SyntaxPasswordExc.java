package org.example.validation.exceptions;

public class SyntaxPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password contains forbidden characters.";
    }
}
