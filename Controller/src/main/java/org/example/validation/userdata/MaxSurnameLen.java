package org.example.validation.userdata;

public class MaxSurnameLen {
    private final String surname;

    public MaxSurnameLen(Data data) {
        this.surname = data.surname;
    }

    public boolean isSuitableLength() {
        return this.surname.length() <= DataFields.MAX_SURNAME.requiredLen;
    }
}
