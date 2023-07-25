package org.example.validation.exceptions;

public final class MaxPublisherExc extends Exception {
    @Override
    public String toString() {
        return "Publisher must consist of maximum 64 characters.";
    }
}
