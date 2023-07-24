package org.example.validation.exceptions;

public class MinDomenMailExc extends Exception {
    @Override
    public String toString() {
        return "Mail must contain minimum 1 character in domen part.";
    }
}
