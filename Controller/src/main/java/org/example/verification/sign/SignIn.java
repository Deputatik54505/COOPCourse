package org.example.verification.sign;

import org.example.entities.user.Users;

import java.util.Scanner;

public class SignIn {
    private final SignVerification signVerification;
    //temporary field, in the future data will be provided from ui form
    private final Scanner scanner;
    public SignIn(Users users) {
        this.signVerification = new SignVerification(users);
        this.scanner = new Scanner(System.in);
    }
    public SignIn withUsers(Users users) {
        return new SignIn(users);
    }
    public void signIn() {
        while (true) {
            try {
                this.signVerification.verifyUser(this.scanner.nextLine(), this.scanner.nextLine());
                System.out.println("Success!");
                break;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
