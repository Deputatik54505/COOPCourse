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

    public User verify(Scanner scanner) {
        while (true) {
            try {
                this.user = this.signVerification.verifyUser(
                        scanner.nextLine(),
                        scanner.nextLine()
                );
                System.out.println("Success!");
                return this.user;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
