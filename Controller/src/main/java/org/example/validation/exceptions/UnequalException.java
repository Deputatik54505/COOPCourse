package org.example.validation.exceptions;

public class UnequalException extends Exception {
    @Override
    public String toString() {
        return "Passwords don't match!";
    }
}
