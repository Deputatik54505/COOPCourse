package org.example.validation.passport;

import org.example.validation.Request;

public class Passport extends Request {
    private final PassportData passportData;
    private final int lenSer = 4;
    private final int lenNum = 6;

    public Passport(String passport) {
        this.passportData = new PassportData(passport);
        this.length = passport.length();
    }

    @Override
    protected boolean isSuitableLength(int len) {
        return this.length == len;
    }
    @Override
    protected boolean isValidInput() {
        for (int i = 0; i < this.passportData.passport.length(); i++) {
            if (!(this.passportData.passport.charAt(i) >= '0' &&
                    this.passportData.passport.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
    public boolean createPassport() {
        return this.passportData.splitData(this.lenSer, this.lenNum);
    }
}
