package org.example.forms.data;

import org.example.entities.user.User;

import java.util.Scanner;

public class FData {
    private final User user;

    private final DataVerification dataVerification;

    public FData(User user) {
        this.user = user;
        this.dataVerification = new DataVerification();
    }

    public FData withUser(User newUser) {
        return new FData(newUser);
    }

    public void verify(Scanner scanner) {
        while (true) {
            try {
                this.dataVerification.verifyData(
                        this.user,
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
