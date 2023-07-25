package org.example.validation.exceptions;

public final class UpPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain uppercase character.";
    }
}
