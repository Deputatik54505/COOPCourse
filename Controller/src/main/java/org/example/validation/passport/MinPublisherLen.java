package org.example.validation.passport;

public class MinPublisherLen {
    private final Passport passport;

    public MinPublisherLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(2).length() >= 8;
    }
}
