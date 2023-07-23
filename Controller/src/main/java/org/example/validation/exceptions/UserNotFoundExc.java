package org.example.validation.exceptions;

public class UserNotFoundExc extends Exception {
    @Override
    public String toString() {
        return "User does not exist.";
    }
}
