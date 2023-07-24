package org.example.validation.exceptions;

public class ExcPassportNumberExc extends Exception {
    @Override
    public String toString() {
        return "Number must consist of 6 characters.";
    }
}
