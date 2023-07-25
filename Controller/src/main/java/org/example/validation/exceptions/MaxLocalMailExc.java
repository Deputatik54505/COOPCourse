package org.example.validation.exceptions;

public final class MaxLocalMailExc extends Exception {
    @Override
    public String toString() {
        return "Mail must contain maximum 64 characters in local part.";
    }
}
