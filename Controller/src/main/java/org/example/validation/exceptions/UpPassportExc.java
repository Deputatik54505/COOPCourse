package org.example.validation.exceptions;

public final class UpPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport must contain uppercase character.";
    }
}
