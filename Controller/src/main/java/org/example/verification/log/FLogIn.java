package org.example.verification.log;

import org.example.entities.users.Users;

import java.util.Scanner;

public class FLogIn {
    private final Users users;

    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;

    private final LogVerification logVerification;

    public FLogIn(Users users) {
        this.users = users;
        this.scanner = new Scanner(System.in);
        this.logVerification = new LogVerification();
    }

    public FLogIn withUsers(Users users) {
        return new FLogIn(users);
    }

    public void verify() {
        while (true) {
            try {
                this.logVerification.verifyUser(this.users,
                        this.scanner.nextLine(),
                        this.scanner.nextLine(),
                        this.scanner.nextLine());
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
