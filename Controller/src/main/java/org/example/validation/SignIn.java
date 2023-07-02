package org.example.validation;

import org.example.entities.user.User;
import org.example.entities.user.Users;

import java.util.Scanner;

public class SignIn {
    private final Users users;
    private User user;
    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;
    public SignIn(Users users) {
        this.users = users;
        this.scanner = new Scanner(System.in);
    }
    public SignIn withUsers(Users users) {
        return new SignIn(users);
    }
    public void signIn() {
        while (true) {
            try {
                this.verifyUser(this.scanner.nextLine(), this.scanner.nextLine());
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    private void verifyUser(String uMail, String uPass) throws Exception {
        try {
            this.user = this.users.findUser(uMail);
            this.user.isEqual(uPass);
        } catch (Exception e) {
            throw e;
        }
    }
}
