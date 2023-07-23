package org.example.validation.exceptions;

public class SyntaxPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect password syntax.";
    }
}
