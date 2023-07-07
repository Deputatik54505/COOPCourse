package org.example;

import org.example.entities.users.Users;
import org.example.verification.log.FLogIn;
import org.example.verification.sign.FSignIn;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();

        //log in
        FLogIn FLogin = new FLogIn(users);
        FLogin.verify();
        //sign in, make it return particular user
        FSignIn FSignIn = new FSignIn(users);
        FSignIn.verify();

        FLogin.verify();

        //account

    }
}