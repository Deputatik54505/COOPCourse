package org.example.validation.userdata;

import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private final String name;

    private final String surname;

    private final String birth;

    public Data(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(
                this.name,
                this.surname,
                this.birth
        ));
    }

    public boolean isSuitableLength() {
        return this.name.length() >= DataFields.MIN_NAME.requiredLen &&
                this.name.length() <= DataFields.MAX_NAME.requiredLen &&
                this.surname.length() >= DataFields.MIN_SURNAME.requiredLen &&
                this.surname.length() <= DataFields.MAX_SURNAME.requiredLen &&
                this.birth.length() == DataFields.BIRTH.requiredLen;
    }
}
