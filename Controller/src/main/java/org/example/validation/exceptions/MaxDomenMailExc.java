package org.example.validation.exceptions;

public class MaxDomenMailExc extends Exception {
    @Override
    public String toString() {
        return "Mail must contain maximum 255 characters in domen part.";
    }
}
