package org.example.validation.exceptions;

public class UpPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain uppercase character.";
    }
}
