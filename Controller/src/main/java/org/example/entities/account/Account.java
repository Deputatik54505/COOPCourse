package org.example.entities.account;

import org.example.validation.passport.Passport;

public class Account {
    private Passport passport;
    public Account() {

    }

    public void fillData() {
        this.passport = new Passport("gkdsnfknsdff", "760054", "4321", "123543").item();
    }

}
