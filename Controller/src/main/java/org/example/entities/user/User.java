package org.example.entities.user;

import org.example.validation.exceptions.NotFoundException;
import org.example.validation.exceptions.UnequalException;

public class User {
    private final String mail;
    private final String password;
    public User(String uMail, String uPass) {
        this.mail = uMail;
        this.password = uPass;
    }
    public boolean isFind(String mail) throws NotFoundException {
        if (this.mail.equals(mail)) {
            return true;
        }
        throw new NotFoundException();
    }
    public void isEqual(String pass) throws UnequalException {
        if (this.password.equals(pass)) {
            return;
        }
        throw new UnequalException();
    }
}
