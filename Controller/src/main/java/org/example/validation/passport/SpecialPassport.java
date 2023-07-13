package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialPassport {
    private final PassportPC passportPC;

    /**
     * \u201e - is a code of sharp(#) symbol
     * \u2013 - is a code of Num (№) symbol
     */
    private final ArrayList<Character> specChar = new ArrayList<>(Arrays.asList(
            '\u201e', '\u2013'
    ));

    public SpecialPassport(Passport passport) {
        this.passportPC = passport.passportPC;
    }

    public boolean isSpecialChar() {
        for (int i = 0; i < this.passportPC.publisher.length(); i++) {
            for (Character character : this.specChar) {
                if (this.passportPC.publisher.charAt(i) == character) {
                    return true;
                }
            }
        }
        return false;
    }
}
