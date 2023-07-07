package org.example.verification.passport;

import org.example.entities.user.User;

import java.util.Scanner;

public class FPassport {
    private final User user;

    private final Scanner scanner;

    private final PassportVerification passportVerification;


    public FPassport(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.passportVerification = new PassportVerification();
    }

    public FPassport withUser(User user) {
        return new FPassport(user);
    }

    public void verify() {
        while (true) {
            try {
                this.passportVerification.verifyPassport(
                        this.user,
                        this.scanner.nextLine(),
                        this.scanner.nextLine(),
                        this.scanner.nextLine(),
                        this.scanner.nextLine()
                );
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

}
