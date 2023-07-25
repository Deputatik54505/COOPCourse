package org.example.validation.password;

public final class NumPassword {
    private final Password cPassword;

    private String password;

    private int passwordLen;

    public NumPassword(Password password) {
        this.cPassword = password;
        this.passwordLen = 0;
    }

    public boolean isNum() {
        this.initData();
        for (int i = 0; i < this.passwordLen; i++) {
            if (this.password.charAt(i) >= '0' &&
                    this.password.charAt(i) <= '9') {
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
