package org.example.forms.data;

import org.example.entities.user.User;
import org.example.validation.userdata.Data;
import org.example.validation.userdata.ValidateData;

public class DataVerification {
    private final ValidateData validateData;

    public DataVerification() {
        this.validateData = new ValidateData();
    }

    public void verifyData(User user, Data data) throws Exception {
        this.validateData.validate(
                data
        );
    }
}
