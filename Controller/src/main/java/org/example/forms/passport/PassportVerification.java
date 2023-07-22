package org.example.forms.passport;

import org.example.entities.user.User;
import org.example.entities.user.UserPassport;
import org.example.validation.passport.Passport;
import org.example.validation.passport.ValidatePassport;

public class PassportVerification {
    private final ValidatePassport validatePassport;

    public PassportVerification() {
        this.validatePassport = new ValidatePassport();
    }

    public void verifyPassport(User user, String publisher, String code, String series, String number) throws Exception {
        this.validatePassport.validate(publisher, code, series, number);
//        new UserPassport(user).fillPassport(new Passport(
//                publisher,
//                code,
//                series,
//                number
//        ));
    }

}
