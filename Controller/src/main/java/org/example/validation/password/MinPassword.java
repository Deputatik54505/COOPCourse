package org.example.validation.password;

public class MinPassword {
    private final Password password;

    public MinPassword(Password password) {
        this.password = password;
    }

    public boolean isSuitableLength() {
        return this.password.passwordLength >= PasswordFields.MIN_LEN.requiredLen;
    }
}
