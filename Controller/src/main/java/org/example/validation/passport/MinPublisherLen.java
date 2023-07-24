package org.example.validation.passport;

public class MinPublisherLen {
    private final String publisher;

    public MinPublisherLen(Passport passport) {
        this.publisher = passport.passportPC.publisher;
    }

    public boolean isSuitableLength() {
        return this.publisher.length() >= PassportFields.MIN_PUBLISHER.requiredLen;
    }
}
