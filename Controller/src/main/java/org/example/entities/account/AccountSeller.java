package org.example.entities.account;

import org.example.validation.passport.Passport;
import org.example.validation.userdata.Data;

public class AccountSeller {
    private final Passport passport;

    private final Data data;

    public AccountSeller() {
        this.passport = new Passport("", "", "", "");
        this.data = new Data("", "", "");
    }

    public AccountSeller(Passport passport, Data data) {
        this.passport = passport;
        this.data = data;
    }

    public AccountSeller withPassport(Passport newPassport) {
        return new AccountSeller(
                newPassport,
                this.data
        );
    }

    public AccountSeller withData(Data newData) {
        return new AccountSeller(
                this.passport,
                newData
        );
    }
}
