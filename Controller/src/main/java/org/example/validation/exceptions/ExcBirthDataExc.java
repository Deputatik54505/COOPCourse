package org.example.validation.exceptions;

public class ExcBirthDataExc extends Exception {
    @Override
    public String toString() {
        return "Birth must consist of 10 characters.";
    }
}
