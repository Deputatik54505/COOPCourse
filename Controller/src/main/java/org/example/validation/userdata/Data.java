package org.example.validation.userdata;

import org.example.validation.Request;

public class Data extends Request {
    private final String name;

    private final String surname;

    private final String birth;

    public Data(String name, String surname, String birth) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
    }

    @Override
    protected boolean isSuitableLength(int[] args) {
        return this.name.length() <= args[0] &&
                this.surname.length() <= args[1] &&
                this.birth.length() <= args[2];
    }

    @Override
    protected boolean isValidInput() {
        return true;
    }
}
