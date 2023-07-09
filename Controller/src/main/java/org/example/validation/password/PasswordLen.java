package org.example.validation.password;

public enum PasswordLen {
    MIN(8),

    MAX(24);

    public int len;

    PasswordLen(int len) {
        this.len = len;
    }
}
