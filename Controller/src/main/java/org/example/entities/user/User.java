package org.example.entities.user;

import org.example.database.Query;
import org.example.forms.log.LogVerification;
import org.example.forms.sign.SignVerification;
import org.example.validation.exceptions.UnequalPasswordExc;
import org.example.validation.exceptions.UserNotFoundExc;

public class User {
    private final UserType type;
    private final String userMail;
    private final String userPassword;
    private final UserData data;

    public User(String mail, String password, String type) {
        this.userMail = mail;
        this.userPassword = password;
        this.type = new UserType(type);
        data = new UserData();
    }

    public void register(String repeatPassword) throws Exception {
        new LogVerification(this.userMail, this.userPassword).verifyUser(this.userPassword, repeatPassword);
        Query query = new Query();
        query.executeWithoutResponse(
                String.format("insert into \"userTable\" (email, password, type) values ('%s', '%s', '%s')",
                        userMail, userPassword, type));
        data.load(userMail);
    }

    public void authorise() throws UnequalPasswordExc, UserNotFoundExc {
        new SignVerification().verifyUser(this.userMail, this.userPassword);
        data.load(userMail);
    }

    public void isEqual(String pass) throws UnequalPasswordExc {
        if (this.userPassword.equals(pass)) {
            return;
        }
        throw new UnequalPasswordExc();
    }

    public UserType type() {
        return type;
    }

    public UserData data() {
        return data;
    }
}
