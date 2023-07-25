package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialPassport {
    private final Passport passport;

    /**
     * \u201e - is a code of sharp(#) symbol
     * \u2013 - is a code of Num (№) symbol
     */
    private final ArrayList<Character> specChar = new ArrayList<>(Arrays.asList(
            '\u201e', '\u2013'
    ));

    public SpecialPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isSpecialChar() {
        return this.validatePublisher(this.passport.provideData().get(2));
    }

    private boolean validatePublisher(String publisher) {
        for (int i = 0; i < publisher.length(); i++) {
            for (Character character : this.specChar) {
                if (publisher.charAt(i) == character) {
                    return true;
                }
            }
        }
        return false;
    }
}
