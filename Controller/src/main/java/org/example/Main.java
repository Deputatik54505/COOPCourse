package org.example;

import org.example.entities.product.Users;
import org.example.validation.Verification;
import org.example.validation.mail.Mail;
import org.example.validation.password.Password;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Verification verification = new Verification();
        Users users = new Users();
        boolean flag = true;
        while (flag) {
            try {
                verification.verifyUser(users, scanner.nextLine(), scanner.nextLine());
                System.out.println("Success!");
                flag = false;
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }

    }
}