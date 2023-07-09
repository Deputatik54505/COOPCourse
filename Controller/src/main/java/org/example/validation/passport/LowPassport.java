package org.example.validation.passport;

public class LowPassport {
    private final PassportPC passportPC;

    public LowPassport(Passport passport) {
        this.passportPC = passport.passportPC;
    }

    public boolean isLowLetter() {
        for (int i = 0; i < this.passportPC.publisher.length(); i++) {
            if (this.passportPC.publisher.charAt(i) >= 'a' &&
                    this.passportPC.publisher.charAt(i) <= 'z') {
                return true;
            }
        }

        return false;
    }
}
