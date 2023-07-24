package org.example.validation.passport;

import org.example.entities.user.User;
import org.example.forms.data.DataVerification;
import org.example.forms.passport.PassportVerification;

public class Passport {
    protected final PassportPC passportPC;

    protected final PassportSN passportSN;

    public Passport(String publisher, String code, String series, String number) {
        this.passportPC = new PassportPC(publisher, code);
        this.passportSN = new PassportSN(series, number);
    }

    public void selfValidation(User user) throws Exception {
        //TODO refactor passport validation
    }

    public boolean isValidInput() {
        return this.passportSN.isValid() && this.passportPC.isValid();
    }

}
