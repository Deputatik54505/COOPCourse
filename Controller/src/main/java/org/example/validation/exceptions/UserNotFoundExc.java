package org.example.validation.exceptions;

public final class UserNotFoundExc extends Exception {
    @Override
    public String toString() {
        return "User does not exist.";
    }
}
