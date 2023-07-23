package org.example.validation.exceptions;

public class SyntaxPassportExc extends Exception {
    @Override
    public String toString() {
        return "Incorrect passport syntax.";
    }
}
