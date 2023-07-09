package org.example.validation.passport;

public class NumPassport {
    private final PassportPC passportPC;

    public NumPassport(Passport passport) {
        this.passportPC = passport.passportPC;
    }

    public boolean isNum() {
        for (int i = 0; i < this.passportPC.publisher.length(); i++) {
            if (this.passportPC.publisher.charAt(i) >= '0' &&
                    this.passportPC.publisher.charAt(i) <= '9') {
                return true;
            }
        }

        return false;
    }
}
