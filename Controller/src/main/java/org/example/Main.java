package org.example;

import org.example.validation.login.Login;
import org.example.validation.login.ValidateLogin;
import org.example.validation.passport.Passport;
import org.example.validation.passport.ValidatePassport;
import org.example.validation.password.Password;
import org.example.validation.password.ValidatePassword;

public class Main {
    public static void main(String[] args) {
        ValidateLogin login = new ValidateLogin();
        login.process(new Login("nfsdfsdfsdfsdffdsgffg"));

        ValidatePassword password = new ValidatePassword();
        password.process(new Password("fsdnfks3424"));

        ValidatePassport passport = new ValidatePassport();
        passport.process(new Passport("38298901"));
    }
}