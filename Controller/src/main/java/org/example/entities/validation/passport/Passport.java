package org.example.entities.validation.passport;

import org.example.entities.validation.Request;

public class Passport extends Request {
    private final String passport;

    public Passport(String passport) {
        this.passport = passport;
        this.length = passport.length();
    }

    @Override
    protected boolean isSuitableLength(int len) {
        return this.length == len;
    }
    @Override
    protected boolean isValidInput() {
        for (int i = 0; i < this.passport.length(); i++) {
            if (!(this.passport.charAt(i) >= '0' && this.passport.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
    public boolean isExist() {
        // TODO: check existence of password
        return true;
    }
}
