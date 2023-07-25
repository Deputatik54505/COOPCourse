package org.example.validation.password;

import java.util.ArrayList;
import java.util.Arrays;

public final class Password {
    private final String userPassword;

    private int passwordLength;

    public Password(String password) {
        this.userPassword = password;
    }

    public void initLength() {
        this.passwordLength = this.userPassword.length();
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(
                this.userPassword,
                Integer.toString(this.passwordLength)
        ));
    }
}
