package org.example.forms.log;

import org.example.entities.buyer.Buyer;
import org.example.tables.Users;
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

    public void verifyUser(Users users, String uMail, String uPass1, String uPass2) throws Exception {
        this.isEqual(uPass1, uPass2);
        this.validateMail.validate(uMail, users);
        this.validatePassword.validate(uPass1);

        users.addUser(new Buyer(uMail, uPass1));
    }

    private void isEqual(String pass1, String pass2) throws UnequalException {
        if (pass1.equals(pass2)) {
            return;
        }
        throw new UnequalException();
    }

}
