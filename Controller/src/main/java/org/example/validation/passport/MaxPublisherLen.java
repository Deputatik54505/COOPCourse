package org.example.validation.passport;

public final class MaxPublisherLen {
    private final Passport passport;

    public MaxPublisherLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(2).length() <= 64;
    }
}
