package org.example.validation.exceptions;

public final class SurnameUpCharExc extends Exception {
    @Override
    public String toString() {
        return "Surname must start with uppercase character.";
    }
}
