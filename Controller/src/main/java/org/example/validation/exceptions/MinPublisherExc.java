package org.example.validation.exceptions;

public final class MinPublisherExc extends Exception {
    @Override
    public String toString() {
        return "Publisher must consist of at least 8 characters.";
    }
}
