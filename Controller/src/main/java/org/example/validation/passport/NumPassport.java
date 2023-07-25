package org.example.validation.passport;

public final class NumPassport {
    private final Passport passport;

    public NumPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isNum() {
        return this.validatePublisher(this.passport.provideData().get(2));
    }

    private boolean validatePublisher(String publisher) {
        for (int i = 0; i < publisher.length(); i++) {
            if (publisher.charAt(i) >= '0' &&
                    publisher.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
