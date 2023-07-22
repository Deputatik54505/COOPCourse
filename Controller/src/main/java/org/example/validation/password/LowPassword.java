package org.example.validation.password;

public class LowPassword {
    private final Password password;

    public LowPassword(Password password) {
        this.password = password;
    }

    public boolean isLowLetter() {
        for (int i = 0; i < this.password.userPassword.length(); i++) {
            if (this.password.userPassword.charAt(i) >= 'a' &&
                    this.password.userPassword.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
}
