package org.example.forms.sign;

import org.example.entities.users.Users;
import org.example.entities.user.User;

import java.util.Scanner;

public class FSignIn {
    private final SignVerification signVerification;

    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;

    private User user;

    public FSignIn(Users users) {
        this.signVerification = new SignVerification(users);
        this.scanner = new Scanner(System.in);
    }

    public FSignIn withUsers(Users users) {
        return new FSignIn(users);
    }

    public User verify() {
        while (true) {
            try {
                this.user = this.signVerification.verifyUser(
                        this.scanner.nextLine(),
                        this.scanner.nextLine()
                );
                System.out.println("Success!");
                return this.user;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
