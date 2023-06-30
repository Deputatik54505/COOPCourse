package org.example.validation;

import org.example.entities.product.User;
import org.example.entities.product.Users;
import org.example.validation.exceptions.VerificationException;
import org.example.validation.mail.ValidateMail;
import org.example.validation.password.ValidatePassword;

public class Verification {
    private final ValidateMail validateMail;
    private final ValidatePassword validatePassword;
    private User newUser;
    public Verification() {
        this.validateMail = new ValidateMail();
        this.validatePassword = new ValidatePassword();
    }

    public void verifyUser(Users users, String uMail, String uPass) throws Exception {
        try {
            this.validateMail.validate(uMail);
            this.validatePassword.validate(uPass);
        } catch (Exception e) {
            throw new VerificationException();
        }
        this.newUser = new User(uMail, uPass);
        users.addUser(this.newUser);
    }

}
