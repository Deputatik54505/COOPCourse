package org.example.validation.userdata;

import org.example.validation.Request;

import java.util.ArrayList;
import java.util.Arrays;

public class Data extends Request {
    private final String name;

    private final String surname;

    private final String birth;

    public Data(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    public ArrayList<String> print() {
        return new ArrayList<>(Arrays.asList(
                this.name,
                this.surname,
                this.birth
        ));
    }

    @Override
    protected boolean isSuitableLength(int[] args) {
        return
                this.name.length() <= args[DataFields.NAME.ordinal()] &&
                this.surname.length() <= args[DataFields.SURNAME.ordinal()] &&
                this.birth.length() <= args[DataFields.BIRTH.ordinal()];
    }

    @Override
    protected boolean isValidInput() {
        return
                new DataName(this).isValid() &&
                new DataSurname(this).isValid() &&
                new DataBirth(this).isValid();
    }
}
