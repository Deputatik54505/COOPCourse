package org.example.validation.passport;

public class SeriesLen {
    private final String series;

    public SeriesLen(Passport passport) {
        this.series = passport.passportSN.series;
    }

    public boolean isSuitableLength() {
        return this.series.length() == PassportFields.SERIES.requiredLen;
    }
}
