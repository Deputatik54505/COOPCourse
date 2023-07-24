package org.example.validation.password;

public class MinPassword {
    private final int passwordLength;

    public MinPassword(Password password) {
        this.passwordLength = password.passwordLength;
    }

    public boolean isSuitableLength() {
        return this.passwordLength >= PasswordFields.MIN_LEN.requiredLen;
    }
}
