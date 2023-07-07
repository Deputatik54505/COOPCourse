package org.example.forms.passport;

import org.example.entities.user.User;

import java.util.Scanner;

public class FPassport {
    private final User user;

    private final PassportVerification passportVerification;


    public FPassport(User user) {
        this.user = user;
        this.passportVerification = new PassportVerification();
    }

    public FPassport withUser(User user) {
        return new FPassport(user);
    }

    public void verify(Scanner scanner) {
        while (true) {
            try {
                this.passportVerification.verifyPassport(
                        this.user,
                        scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextLine()
                );
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}
