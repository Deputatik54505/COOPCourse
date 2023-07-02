package org.example.verification.log;

import org.example.entities.user.Users;

import java.util.Scanner;

public class LogIn {
    private final Users users;
    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;

    private final LogVerification logVerification;

    public LogIn(Users users) {
        this.users = users;
        this.scanner = new Scanner(System.in);
        this.logVerification = new LogVerification();
    }
    public LogIn withUsers(Users users) {
        return new LogIn(users);
    }
    public void logIn() {
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
