package org.example.verification.log;

import org.example.entities.user.User;
import org.example.entities.users.Users;
import org.example.validation.exceptions.UnequalException;
import org.example.validation.mail.ValidateMail;
import org.example.validation.password.ValidatePassword;

public class LogVerification {
    private final ValidateMail validateMail;

    private final ValidatePassword validatePassword;

    private User user;

    public LogVerification() {
        this.validateMail = new ValidateMail();
        this.validatePassword = new ValidatePassword();
    }

    public void verifyUser(Users users, String uMail, String uPass1, String uPass2) throws Exception {
        this.isEqual(uPass1, uPass2);
        this.validateMail.validate(uMail, users);
        this.validatePassword.validate(uPass1);

        this.user = new User(uMail, uPass1);
        users.addUser(this.user);
    }

    private void isEqual(String pass1, String pass2) throws UnequalException {
        if (pass1.equals(pass2)) {
            return;
        }
        throw new UnequalException();
    }

}
