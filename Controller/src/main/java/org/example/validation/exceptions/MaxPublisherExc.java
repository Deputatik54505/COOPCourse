package org.example.validation.exceptions;

public class MaxPublisherExc extends Exception {
    @Override
    public String toString() {
        return "Publisher must consist of maximum 64 characters.";
    }
}
