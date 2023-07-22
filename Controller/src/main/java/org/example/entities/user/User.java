package org.example.entities.user;

import org.example.database.Query;
import org.example.forms.log.LogVerification;
import org.example.forms.sign.SignVerification;
import org.example.validation.exceptions.UnequalException;

public class User {
    public final String userType;
    private final String userMail;
    private final String userPassword;

    public User(String mail, String password, String type) {
        this.userMail = mail;
        this.userPassword = password;
        this.userType = type;
    }

    public void selfRegistration(String repeatPassword) throws Exception {
        new LogVerification().verifyUser(this.userMail, this.userPassword, repeatPassword);

        var query = new Query();
        query.executeQuery(
                String.format("insert into \"userTable\" (email, password) values ('%s', '%s')", userMail, userPassword));
    }

    public void selfAuthorization() {
        new SignVerification().verifyUser(this.userMail, this.userPassword);
    }

    public void isEqual(String pass) throws UnequalException {
        if (this.userPassword.equals(pass)) {
            return;
        }
        throw new UnequalException();
    }
}
