package org.example.validation.password;

public class UpPassword {
    private final String password;

    public UpPassword(Password password) {
        this.password = password.userPassword;
    }

    public boolean isUpLetter() {
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) >= 'A' &&
                    this.password.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
