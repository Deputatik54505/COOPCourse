package org.example.forms.sign;

import org.example.entities.user.User;

public class SignVerification {
    private User user;

    public SignVerification() {

    }

    public void verifyUser(String uMail, String uPass) throws Exception {
        //TODO find the user in DB by mail
        //TODO check the equality of passwords

//        this.user = this.users.findUser(uMail);
//        this.user.isEqual(uPass);
    }
}
