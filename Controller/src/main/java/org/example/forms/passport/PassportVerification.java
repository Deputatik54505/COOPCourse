package org.example.forms.passport;

import org.example.validation.passport.Passport;
import org.example.validation.passport.ValidatePassport;

public class PassportVerification {
    private final ValidatePassport validatePassport;

    public PassportVerification(Passport passport) {
        this.validatePassport = new ValidatePassport(passport);
    }

    public void verifyPassport() throws Exception {
        this.validatePassport.validate();
    }

}
