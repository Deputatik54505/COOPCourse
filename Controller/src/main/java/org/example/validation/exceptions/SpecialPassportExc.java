package org.example.validation.exceptions;

public final class SpecialPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport's publisher must contain special character.";
    }
}
