package org.example.validation.passport;

public final class MinPublisherLen {
    private final Passport passport;

    public MinPublisherLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(2).length() >= 8;
    }
}
