package org.example.validation.password;

public class Password {
    protected final String userPassword;

    protected int passwordLength;

    public Password(String password) {
        this.userPassword = password;
    }

    public void initLength() {
        this.passwordLength = this.userPassword.length();
    }
}
