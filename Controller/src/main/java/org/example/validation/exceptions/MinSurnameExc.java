package org.example.validation.exceptions;

public class MinSurnameExc extends Exception {
    @Override
    public String toString() {
        return "Surname must consist of at least 3 characters.";
    }
}
