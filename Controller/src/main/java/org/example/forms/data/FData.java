package org.example.forms.data;

import org.example.entities.user.User;

import java.util.Scanner;

public class FData {
    private final User user;

    private final Scanner scanner;

    private final DataVerification dataVerification;

    public FData(User user) {
        this.user = user;
        this.scanner = new Scanner(System.in);
        this.dataVerification = new DataVerification();
    }

    public FData withUser(User newUser) {
        return new FData(newUser);
    }

    public void verify() {
        while (true) {
            try {
                this.dataVerification.verifyData(
                        this.user,
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
