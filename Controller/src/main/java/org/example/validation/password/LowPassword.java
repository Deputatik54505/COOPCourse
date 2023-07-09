package org.example.validation.password;

public class LowPassword {
    private final Password password;

    public LowPassword(Password password) {
        this.password = password;
    }

    public boolean isLowLetter() {
        for (int i = 0; i < this.password.password.length(); i++) {
            if (this.password.password.charAt(i) >= 'a' &&
                    this.password.password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
}
