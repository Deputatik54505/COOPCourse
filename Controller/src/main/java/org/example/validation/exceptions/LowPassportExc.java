package org.example.validation.exceptions;

public final class LowPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport must contain lowercase character.";
    }
}
