package org.example.entities.user;

import org.example.database.Query;
import org.example.forms.log.LogVerification;
import org.example.forms.sign.SignVerification;
import org.example.validation.exceptions.UnequalPasswordExc;
import org.example.validation.exceptions.UserNotFoundExc;

import java.sql.SQLException;

public class User {
    public UserData data;
    public final String userType;
    private final String userMail;
    private final String userPassword;

    public User(String mail, String password, String type) {
        this.userMail = mail;
        this.userPassword = password;
        this.userType = type;
        data = new UserData();
    }

    public void selfRegistration(String repeatPassword) throws Exception {
        new LogVerification().verifyUser(this.userMail, this.userPassword, repeatPassword);

        var query = new Query();
        query.executeQuery(
                String.format("insert into \"userTable\" (email, password, type) values ('%s', '%s', '%s')",
                        userMail, userPassword, userType));
        data.load(userMail);
    }

    public void selfAuthorization() throws SQLException, UnequalPasswordExc, UserNotFoundExc {
        new SignVerification().verifyUser(this.userMail, this.userPassword);
        data.load(userMail);
    }

    public void isEqual(String pass) throws UnequalPasswordExc {
        if (this.userPassword.equals(pass)) {
            return;
        }
        throw new UnequalPasswordExc();
    }
}
