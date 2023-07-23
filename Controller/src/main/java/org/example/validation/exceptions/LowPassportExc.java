package org.example.validation.exceptions;

public class LowPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport must contain lowercase character.";
    }
}
