package org.example.validation.password;

public class Password {
    protected final String userPassword;

    public Password(String password) {
        this.userPassword = password;
    }

    public boolean isSuitableLength() {
        return
                this.userPassword.length() >= PasswordFields.MIN_LEN.requiredLen &&
                this.userPassword.length() <= PasswordFields.MAX_LEN.requiredLen;
    }
}
