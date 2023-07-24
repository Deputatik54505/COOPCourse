package org.example.validation.password;

public class NumPassword {
    private final String password;

    public NumPassword(Password password) {
        this.password = password.userPassword;
    }

    public boolean isNum() {
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) >= '0' &&
                    this.password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
