package org.example.validation.userdata;

import org.example.forms.data.DataVerification;

import java.util.ArrayList;
import java.util.Arrays;

public final class Data {
    private final String name;

    private final String surname;

    private final String birth;

    public Data(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public void selfValidation() throws Exception {
        new DataVerification(this).verifyData();
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(
           this.name,
           this.surname,
           this.birth
        ));
    }
}
