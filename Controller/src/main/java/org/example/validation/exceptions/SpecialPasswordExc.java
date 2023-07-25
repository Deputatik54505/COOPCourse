package org.example.validation.exceptions;

public final class SpecialPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain special character, e.g. @, &.";
    }
}
