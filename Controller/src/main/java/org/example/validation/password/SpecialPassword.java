package org.example.validation.password;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialPassword {
    private final Password password;

    /**
     * \u201e - is a code of sharp(#) symbol
     * \u2013 - is a code of Num (№) symbol
     */
    private final ArrayList<Character> specChar = new ArrayList<>(Arrays.asList(
            '\u201e', '\u2013', '@', '&'
    ));

    public SpecialPassword(Password password) {
        this.password = password;
    }

    public boolean isSpecialChar() {
        for (int i = 0; i < this.password.password.length(); i++) {
            for (Character character : this.specChar) {
                if (this.password.password.charAt(i) == character) {
                    return true;
                }
            }
        }
        return false;
    }
}
