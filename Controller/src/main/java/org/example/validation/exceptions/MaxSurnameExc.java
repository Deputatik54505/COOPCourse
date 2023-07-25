package org.example.validation.exceptions;

public final class MaxSurnameExc extends Exception {
    @Override
    public String toString() {
        return "Surname must consist of maximum 20 characters.";
    }
}
