package org.example.validation.userdata;

import org.example.forms.data.DataVerification;

public class Data {
    protected final String name;

    protected final String surname;

    protected final String birth;

    public Data(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public void selfValidation() throws Exception {
        new DataVerification(this).verifyData();
    }
}
