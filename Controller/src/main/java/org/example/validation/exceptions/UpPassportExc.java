package org.example.validation.exceptions;

public class UpPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport must contain uppercase character.";
    }
}
