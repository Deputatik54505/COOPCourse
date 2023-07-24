package org.example.validation.password;

public class LowPassword {
    private final Password cPassword;

    private String password;

    private int passwordLen;

    public LowPassword(Password password) {
        this.cPassword = password;
    }

    public boolean isLowLetter() {
        this.initData();
        for (int i = 0; i < this.passwordLen; i++) {
            if (this.password.charAt(i) >= 'a' &&
                    this.password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    private void initData() {
        this.password = this.cPassword.provideData().get(0);
        this.passwordLen = Integer.parseInt(this.cPassword.provideData().get(1));
    }
}
