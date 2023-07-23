package org.example.forms.log;

import org.example.validation.exceptions.UnequalPasswordExc;
import org.example.validation.mail.ValidateMail;
import org.example.validation.password.ValidatePassword;

public class LogVerification {
    private final ValidateMail validateMail;

    private final ValidatePassword validatePassword;

    public LogVerification() {
        this.validateMail = new ValidateMail();
        this.validatePassword = new ValidatePassword();
    }

    public void verifyUser(String userMail, String userPassword, String repeatPassword) throws Exception {
        try {
            this.isEqual(userPassword, repeatPassword);
            this.validateMail.validate(userMail);
            this.validatePassword.validate(userPassword);
        } catch (Exception e) {
            throw e;
        }

    }

    private void isEqual(String pass1, String pass2) throws UnequalPasswordExc {
        if (pass1.equals(pass2)) {
            return;
        }
        throw new UnequalPasswordExc();
    }

}
