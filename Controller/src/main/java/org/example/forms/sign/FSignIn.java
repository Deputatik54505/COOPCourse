package org.example.forms.sign;

import org.example.tables.Users;
import org.example.entities.user.User;

import java.util.Scanner;

public class FSignIn {
    private final SignVerification signVerification;

    private User user;

    public FSignIn(Users users) {
        this.signVerification = new SignVerification(users);
    }

    public FSignIn withUsers(Users users) {
        return new FSignIn(users);
    }

    public void verify(String mail, String password) throws Exception {
        while (true) {
            this.user = this.signVerification.verifyUser(
                    mail,
                    password
            );
            System.out.println("Success!");
            break;
        }
    }
}
