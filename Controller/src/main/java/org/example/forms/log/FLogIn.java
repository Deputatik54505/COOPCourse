package org.example.forms.log;

import org.example.entities.users.Users;

public class FLogIn {
    private final Users users;

    private final LogVerification logVerification;

    public FLogIn(Users users) {
        this.users = users;
        this.logVerification = new LogVerification();
    }

    public FLogIn withUsers(Users users) {
        return new FLogIn(users);
    }

    public void verify(String mail, String password, String repeatPassword) throws Exception {
        while (true) {
            this.logVerification.verifyUser(
                    this.users,
                    mail,
                    password,
                    repeatPassword
            );
            System.out.println("Success!");
            break;
        }
    }
}
