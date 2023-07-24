package org.example.validation.password;

public class MaxPassword {
    private final int passwordLength;

    public MaxPassword(Password password) {
        this.passwordLength = password.passwordLength;
    }

    public boolean isSuitableLength() {
        return this.passwordLength <= PasswordFields.MAX_LEN.requiredLen;
    }
}
