package org.example.validation.exceptions;

public final class ExcPassportSeriesExc extends Exception {
    @Override
    public String toString() {
        return "Series must consist of 4 characters.";
    }
}
