package org.example.forms.log;

import org.example.tables.Users;

import java.util.Scanner;

public class FLogIn {
    private final Users users;

    private final LogVerification logVerification;

    public FLogIn(Users users) {
        this.users = users;
        this.logVerification = new LogVerification();
    }

    public FLogIn withUsers(Users users) {
        return new FLogIn(users);
    }

    public void verify(Scanner scanner) {
        while (true) {
            try {
                this.logVerification.verifyUser(
                        this.users,
                        scanner.nextLine(),
                        scanner.nextLine(),
                        scanner.nextLine());
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
