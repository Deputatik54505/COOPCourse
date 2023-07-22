package org.example.forms.log;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;
import org.example.validation.exceptions.UnequalException;
import org.example.validation.mail.ValidateMail;
import org.example.validation.password.ValidatePassword;

public class LogVerification {
    private final ValidateMail validateMail;

    private final ValidatePassword validatePassword;

    public LogVerification() {
        this.validateMail = new ValidateMail();
        this.validatePassword = new ValidatePassword();
    }

    public void verifyUser(String userMail, String userPassword, String repeatPassword) throws UnequalException, SyntaxException, LengthException {
        try {
            this.isEqual(userPassword, repeatPassword);
            this.validateMail.validate(userMail);
            this.validatePassword.validate(userPassword);
        } catch (UnequalException | LengthException | SyntaxException e) {
            throw e;
        }

    }

    private void isEqual(String pass1, String pass2) throws UnequalException {
        if (pass1.equals(pass2)) {
            return;
        }
        throw new UnequalException();
    }

}
