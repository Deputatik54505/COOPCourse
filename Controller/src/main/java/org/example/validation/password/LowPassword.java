package org.example.validation.password;

public class LowPassword {
    private final String password;

    public LowPassword(Password password) {
        this.password = password.userPassword;
    }

    public boolean isLowLetter() {
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) >= 'a' &&
                    this.password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
}
