package org.example.validation.exceptions;

public class NameUpCharExc extends Exception {
    @Override
    public String toString() {
        return "Name must start with uppercase character.";
    }
}
