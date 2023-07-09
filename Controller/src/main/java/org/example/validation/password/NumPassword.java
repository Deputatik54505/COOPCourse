package org.example.validation.password;

public class NumPassword {
    private final Password password;

    public NumPassword(Password password) {
        this.password = password;
    }

    public boolean isNum() {
        for (int i = 0; i < this.password.password.length(); i++) {
            if (this.password.password.charAt(i) >= '0' &&
                    this.password.password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
