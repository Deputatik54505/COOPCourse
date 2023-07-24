package org.example.forms.data;

import org.example.validation.userdata.Data;
import org.example.validation.userdata.ValidateData;

public class DataVerification {
    private final ValidateData validateData;

    public DataVerification(Data data) {
        this.validateData = new ValidateData(data);
    }

    public void verifyData() throws Exception {
        this.validateData.validate();
    }
}
