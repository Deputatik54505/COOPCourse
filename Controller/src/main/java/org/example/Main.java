package org.example;

import org.example.entities.user.Users;
import org.example.validation.LogIn;
import org.example.validation.SignIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Users users = new Users();

        //log in
        LogIn logIn = new LogIn(users);
        logIn.logIn();
        //sign in
        SignIn signIn = new SignIn(users);
        signIn.signIn();
    }
}