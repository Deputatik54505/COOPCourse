package org.example.validation.userdata;

public final class SurnameUpChar {
    private final Data data;

    public SurnameUpChar(Data data) {
        this.data = data;
    }

    public boolean isUppercase() {
        return this.validateSurname(this.data.provideData().get(1));
    }

    private boolean validateSurname(String surname) {
        return surname.charAt(0) >= 'A' && surname.charAt(0) <= 'Z';
    }
}
