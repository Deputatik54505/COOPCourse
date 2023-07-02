package org.example.validation.exceptions;

public class DuplicationException extends Exception {
    @Override
    public String toString() {
        return "The user with such an email already exists!";
    }
}
