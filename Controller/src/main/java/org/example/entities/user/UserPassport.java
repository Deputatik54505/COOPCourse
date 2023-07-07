package org.example.entities.user;

import org.example.validation.passport.Passport;

public class UserPassport {
    private final User user;

    public UserPassport(User user) {
        this.user = user;
    }

    public void fillPassport(Passport passport) {
        this.user.account = this.user.account.withPassport(passport);
    }
}
