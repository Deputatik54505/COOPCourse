package org.example.validation.passport;

public class NumberLen {
    private final String number;

    public NumberLen(Passport passport) {
        this.number = passport.passportSN.number;
    }

    public boolean isSuitableLength() {
        return this.number.length() == PassportFields.NUMBER.requiredLen;
    }
}
