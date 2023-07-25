package org.example.validation.exceptions;

public final class SyntaxPassportExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect passport syntax.";
    }
}
