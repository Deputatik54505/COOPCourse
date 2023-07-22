package org.example.validation.password;

public class UpPassword {
    private final Password password;

    public UpPassword(Password password) {
        this.password = password;
    }

    public boolean isUpLetter() {
        for (int i = 0; i < this.password.userPassword.length(); i++) {
            if (this.password.userPassword.charAt(i) >= 'A' &&
                    this.password.userPassword.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
