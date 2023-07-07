package org.example.entities.account;

import org.example.validation.userdata.Data;
import org.example.validation.passport.Passport;

public class Account {

    private final Passport passport;

    private final Data data;

    public Account() {
        this.passport = new Passport("", "", "", "");
        this.data = new Data("", "", "");
    }

    public Account(Passport passport, Data data) {
        this.passport = passport;
        this.data = data;
    }

    public Account withPassport(Passport newPassport) {
        return new Account(
                newPassport,
                this.data
        );
    }

    public Account withData(Data newData) {
        return new Account(
                this.passport,
                newData
        );
    }
}
