package org.example.verification.sign;

import org.example.entities.user.User;
import org.example.entities.user.Users;

public class SignVerification {
    private final Users users;
    private User user;

    public SignVerification(Users users) {
        this.users = users;
    }

    public void verifyUser(String uMail, String uPass) throws Exception {
        this.user = this.users.findUser(uMail);
        this.user.isEqual(uPass);
    }
}
