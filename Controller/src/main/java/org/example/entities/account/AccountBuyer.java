package org.example.entities.account;

import org.example.validation.userdata.Data;
import org.example.validation.passport.Passport;

public class AccountBuyer {

    private final Passport passport;

    private final Data data;

    public AccountBuyer() {
        this.passport = new Passport("", "", "", "");
        this.data = new Data("", "", "");
    }

    public AccountBuyer(Passport passport, Data data) {
        this.passport = passport;
        this.data = data;
    }

    public AccountBuyer withPassport(Passport newPassport) {
        return new AccountBuyer(
                newPassport,
                this.data
        );
    }

    public AccountBuyer withData(Data newData) {
        return new AccountBuyer(
                this.passport,
                newData
        );
    }
}
