package org.example;

import org.example.entities.user.Users;
import org.example.verification.log.LogIn;
import org.example.verification.sign.SignIn;

public class Main {
    public static void main(String[] args) {

        Users users = new Users();

        //log in
        LogIn logIn = new LogIn(users);
        logIn.logIn();
        //sign in
        SignIn signIn = new SignIn(users);
        signIn.signIn();

        logIn.logIn();

    }
}