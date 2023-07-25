package org.example.validation.passport;

public final class NumberLen {
    private final Passport passport;

    public NumberLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(1).length() == 6;
    }
}
