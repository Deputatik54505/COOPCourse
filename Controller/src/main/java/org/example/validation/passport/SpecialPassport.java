package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialPassport {
    private final PassportPC passportPC;

    private final ArrayList<Character> specChar = new ArrayList<>(Arrays.asList(
            '#', '№'
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
