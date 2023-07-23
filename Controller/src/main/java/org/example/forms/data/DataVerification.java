package org.example.forms.data;

import org.example.entities.user.User;
import org.example.validation.userdata.ValidateData;

public class DataVerification {
    private final ValidateData validateData;

    public DataVerification() {
        this.validateData = new ValidateData();
    }

    public void verifyData(User user, String name, String surname, String birth) throws Exception {
        this.validateData.validate(
                name,
                surname,
                birth
        );
//        new UserData(user).fillData(new Data(
//                name,
//                surname,
//                birth
//        ));
    }
}
