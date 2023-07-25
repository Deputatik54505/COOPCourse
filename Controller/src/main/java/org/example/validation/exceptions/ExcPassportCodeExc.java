package org.example.validation.exceptions;

public final class ExcPassportCodeExc extends Exception {
    @Override
    public String toString() {
        return "Code must consist of 6 characters.";
    }
}
