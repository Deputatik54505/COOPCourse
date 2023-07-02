package org.example.validation;

import org.example.entities.user.User;
import org.example.entities.user.Users;
import org.example.validation.exceptions.UnequalException;
import org.example.validation.mail.ValidateMail;
import org.example.validation.password.ValidatePassword;

import java.util.Scanner;

public class LogIn {
    private final ValidateMail validateMail;
    private final ValidatePassword validatePassword;
    private final Users users;
    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;
    private User newUser;

    public LogIn(Users users) {
        this.validateMail = new ValidateMail();
        this.validatePassword = new ValidatePassword();
        this.users = users;
        this.scanner = new Scanner(System.in);
    }
    public LogIn withUsers(Users users) {
        return new LogIn(users);
    }
    public void logIn() {
        while (true) {
            try {
                this.verifyUser(users, scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    public void verifyUser(Users users, String uMail, String uPass1, String uPass2) throws Exception {
        try {
            this.isEqual(uPass1, uPass2);
            this.validateMail.validate(uMail);
            this.validatePassword.validate(uPass1);
        } catch (Exception e) {
            throw e;
        }
        this.newUser = new User(uMail, uPass1);
        users.addUser(this.newUser);
    }
    public void isEqual(String pass1, String pass2) throws Exception {
        if (pass1.equals(pass2)) {
            return;
        }
        throw new UnequalException();
    }
}
