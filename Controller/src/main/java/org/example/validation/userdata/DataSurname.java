package org.example.validation.userdata;

public final class DataSurname {
    private final Data data;

    public DataSurname(Data data) {
        this.data = data;
    }

    public boolean isValidInput() {
        return this.validateSurname(this.data.provideData().get(1));
    }

    private boolean validateSurname(String surname) {
        for (int i = 1; i < surname.length(); i++) {
            if (!(
                    (surname.charAt(i) >= 'a' &&
                            surname.charAt(i) <= 'z') ||
                            (surname.charAt(i) >= 'A' &&
                                    surname.charAt(i) <= 'Z')
            )) {
                return false;
            }
        }
        return true;
    }
}
