package org.example.validation.passport;

public final class LowPassport {
    private final Passport passport;

    public LowPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isLowLetter() {
        return this.validatePublisher(this.passport.provideData().get(2));
    }

    private boolean validatePublisher(String publisher) {
        for (int i = 0; i < publisher.length(); i++) {
            if (publisher.charAt(i) >= 'a' &&
                    publisher.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
}
