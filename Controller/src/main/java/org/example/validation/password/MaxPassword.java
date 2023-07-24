package org.example.validation.password;

public class MaxPassword {
    private final Password password;

    public MaxPassword(Password password) {
        this.password = password;
    }

    public boolean isSuitableLength() {
        return this.password.passwordLength <= PasswordFields.MAX_LEN.requiredLen;
    }
}
