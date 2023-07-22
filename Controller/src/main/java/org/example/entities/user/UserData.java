package org.example.entities.user;

import org.example.validation.userdata.Data;

public class UserData {
    private final User user;

    public UserData(User user) {
        this.user = user;
    }

//    public void fillData(Data data) {
//        this.user.account = this.user.account.withData(data);
//    }
}
