package org.example.validation.passport;

public final class SeriesLen {
    private final Passport passport;

    public SeriesLen(Passport passport) {
        this.passport = passport;
    }

    public boolean isSuitableLength() {
        return this.passport.provideData().get(0).length() == 6;
    }
}
