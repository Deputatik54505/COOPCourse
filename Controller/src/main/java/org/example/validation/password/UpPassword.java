package org.example.validation.password;

public class UpPassword {
    private final Password password;

    public UpPassword(Password password) {
        this.password = password;
    }

    public boolean isUpLetter() {
        for (int i = 0; i < this.password.password.length(); i++) {
            if (this.password.password.charAt(i) >= 'A' &&
                    this.password.password.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
