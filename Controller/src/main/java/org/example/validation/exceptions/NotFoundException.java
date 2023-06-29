package org.example.validation.exceptions;

public class NotFoundException extends Exception {
    @Override
    public String toString() {
        return "User not found!";
    }
}
