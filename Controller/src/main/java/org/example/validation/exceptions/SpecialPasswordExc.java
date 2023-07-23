package org.example.validation.exceptions;

public class SpecialPasswordExc extends Exception {
    @Override
    public String toString() {
        return "Password must contain special character.";
    }
}
