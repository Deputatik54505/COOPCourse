package org.example.validation.exceptions;

public final class MinLocalMailExc extends Exception {
    @Override
    public String toString() {
        return "Mail must contain minimum 1 character in local part.";
    }
}
