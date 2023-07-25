package org.example.validation.exceptions;

public final class ExcPassportNumberExc extends Exception {
    @Override
    public String toString() {
        return "Number must consist of 6 characters.";
    }
}
