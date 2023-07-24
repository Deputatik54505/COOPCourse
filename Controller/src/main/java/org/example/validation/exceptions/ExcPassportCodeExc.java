package org.example.validation.exceptions;

public class ExcPassportCodeExc extends Exception {
    @Override
    public String toString() {
        return "Code must consist of 6 characters.";
    }
}
