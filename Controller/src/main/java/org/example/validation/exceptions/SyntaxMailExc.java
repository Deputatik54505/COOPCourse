package org.example.validation.exceptions;

public final class SyntaxMailExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect mail syntax.";
    }
}
