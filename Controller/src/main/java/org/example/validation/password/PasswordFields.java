package org.example.validation.password;

public enum PasswordFields {
    MIN_LEN(8),
    MAX_LEN(24);
    public final int requiredLen;
    PasswordFields(int len) {
        this.requiredLen = len;
    }
}
