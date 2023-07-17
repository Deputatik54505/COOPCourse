package org.example;

import org.example.entities.user.User;
import org.example.tables.Users;
import org.example.forms.data.FData;
import org.example.forms.log.FLogIn;
import org.example.forms.passport.FPassport;
import org.example.forms.sign.FSignIn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Users users = new Users();
        //temporary field, in the future the data will be written from forms
        Scanner scanner = new Scanner(System.in);


        //Form: log in
        FLogIn fLogIn = new FLogIn(users);
        fLogIn.verify(scanner);

        //Form: sign in
        FSignIn fSignIn = new FSignIn(users);
        User particularUser = fSignIn.verify(scanner);

        //Form: add passport
        FPassport fPassport = new FPassport(particularUser);
        fPassport.verify(scanner);

        //Form: add user data (name, surname, date of birth)
        FData fData = new FData(particularUser);
        fData.verify(scanner);

        fLogIn.verify(scanner);
    }
}