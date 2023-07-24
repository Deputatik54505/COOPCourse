package org.example.validation.passport;

public class CodeLen {
    private final Passport passport;

    public CodeLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(3).length() == 6;
    }

}
