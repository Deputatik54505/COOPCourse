package org.example.validation.passport;

public final class UpPassport {
    private final Passport passport;

    public UpPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isUpLetter() {
        return this.validatePublisher(this.passport.provideData().get(2));
    }

    private boolean validatePublisher(String publisher) {
        for (int i = 0; i < publisher.length(); i++) {
            if (publisher.charAt(i) >= 'A' &&
                    publisher.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }
}
