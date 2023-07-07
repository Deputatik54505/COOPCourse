package org.example;

import org.example.entities.user.User;
import org.example.entities.users.Users;
import org.example.forms.data.FData;
import org.example.forms.log.FLogIn;
import org.example.forms.passport.FPassport;
import org.example.forms.sign.FSignIn;

public class Main {
    public static void main(String[] args) {
        Users users = new Users();

        //Form: log in
        FLogIn fLogIn = new FLogIn(users);
        fLogIn.verify();

        //Form: sign in
        FSignIn fSignIn = new FSignIn(users);
        User particularUser = fSignIn.verify();

        //Form: add passport
        FPassport fPassport = new FPassport(particularUser);
        fPassport.verify();

        //Form: add user data (name, surname, date of birth)
        FData fData = new FData(particularUser);
        fData.verify();

        fLogIn.verify();
    }
}