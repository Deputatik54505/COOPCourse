package org.example.validation.password;

public class AlphaChecker {
    Password cPassword;
    public AlphaChecker(Password password) {
        this.cPassword = password;
    }
    public boolean isUpLetter() {
        for (int i = 0; i < this.cPassword.password.length(); i++) {
            if (this.cPassword.password.charAt(i) >= 'A' &&
                    this.cPassword.password.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }
    public boolean isLowLetter() {
        for (int i = 0; i < this.cPassword.password.length(); i++) {
            if (this.cPassword.password.charAt(i) >= 'a' &&
                    this.cPassword.password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
    public boolean isNum() {
        for (int i = 0; i < this.cPassword.password.length(); i++) {
            if (this.cPassword.password.charAt(i) >= '0' &&
                    this.cPassword.password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
