package org.example.entities.product;

public class User {
    private final String mail;
    private final String password;
    public User(String uMail, String uPass) {
        this.mail = uMail;
        this.password = uPass;
    }
    public boolean isFind(String mail) {
        return this.mail.equals(mail);
    }
}
