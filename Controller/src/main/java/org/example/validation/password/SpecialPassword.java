package org.example.validation.password;

import java.util.ArrayList;
import java.util.Arrays;

public class SpecialPassword {
    private final String password;

    private final ArrayList<Character> specChars;

    public SpecialPassword(Password password) {
        this.password = password.userPassword;
        this.specChars = new ArrayList<>();
    }

    public boolean isSpecialChar() {
        this.initSpecChars();

        for (int i = 0; i < this.password.length(); i++) {
            for (Character character : this.specChars) {
                if (this.password.charAt(i) == character) {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     * \u201e - is a code of sharp(#) symbol
     * \u2013 - is a code of Num (№) symbol
     */
    private void initSpecChars() {
        this.specChars.addAll(Arrays.asList(
                '\u201e', '\u2013', '@', '&'
        ));
    }
}
