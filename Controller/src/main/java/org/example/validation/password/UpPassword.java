package org.example.validation.password;

public final class UpPassword {
    private final Password cPassword;

    private String password;

    private int passwordLen;

    public UpPassword(Password password) {
        this.cPassword = password;
    }

    public boolean isUpLetter() {
        this.initData();
        for (int i = 0; i < this.passwordLen; i++) {
            if (this.password.charAt(i) >= 'A' &&
                    this.password.charAt(i) <= 'Z') {
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
