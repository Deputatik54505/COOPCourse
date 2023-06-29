package org.example.validation.exceptions;

public class VerificationException extends Exception {
    @Override
    public String toString() {
        return "Verification failed!";
    }
}
