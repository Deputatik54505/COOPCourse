package org.example.forms.sign;

import org.example.entities.user.User;
import org.example.entities.users.Users;

public class SignVerification {
    private final Users users;

    private User user;

    public SignVerification(Users users) {
        this.users = users;
    }

    public User verifyUser(String uMail, String uPass) throws Exception {
        this.user = this.users.findUser(uMail);
        this.user.isEqual(uPass);
        return this.user;
    }
}
