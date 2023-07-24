package org.example.validation.userdata;

public class MinSurnameLen {
    private final String surname;

    public MinSurnameLen(Data data) {
        this.surname = data.surname;
    }

    public boolean isSuitableLength() {
        return this.surname.length() >= DataFields.MIN_SURNAME.requiredLen;
    }
}
