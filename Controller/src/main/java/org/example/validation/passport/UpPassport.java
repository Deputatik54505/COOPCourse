package org.example.validation.passport;

public class UpPassport {
    private final PassportPC passportPC;

    public UpPassport(Passport passport) {
        this.passportPC = passport.passportPC;
    }

    public boolean isUpLetter() {
        for (int i = 0; i < this.passportPC.publisher.length(); i++) {
            if (this.passportPC.publisher.charAt(i) >= 'A' &&
                    this.passportPC.publisher.charAt(i) <= 'Z') {
                return true;
            }
        }

        return false;
    }
}
