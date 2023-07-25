package org.example.validation.exceptions;

public final class NumPassportExc extends Exception {
    @Override
    public String toString() {
        return "Passport's publisher must contain digit.";
    }
}
