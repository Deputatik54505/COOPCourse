package org.example.validation.passport;

public class MaxPublisherLen {
    private final String publisher;

    public MaxPublisherLen(Passport passport) {
        this.publisher = passport.passportPC.publisher;
    }

    public boolean isSuitableLength() {
        return this.publisher.length() <= PassportFields.MAX_PUBLISHER.requiredLen;
    }
}
