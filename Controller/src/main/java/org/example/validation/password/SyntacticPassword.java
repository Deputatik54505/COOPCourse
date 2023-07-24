package org.example.validation.password;

import java.util.ArrayList;
import java.util.Arrays;

public class SyntacticPassword {
    private final String password;

    private final ArrayList<Character> forbidChars;

    public SyntacticPassword(Password password) {
        this.password = password.userPassword;
        this.forbidChars = new ArrayList<>();
    }

    public boolean isValidInput() {
        this.initForbidChars();

        for (int i = 0; i < this.password.length(); i++) {
            for (Character character : this.forbidChars) {
                if (this.password.charAt(i) == character) {
                    return false;
                }
            }
        }

        return true;
    }

    private void initForbidChars() {
        this.forbidChars.addAll(Arrays.asList(
                '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
                '<', '>', '$', '^', '"', ' ', '!',
                ',','.',';','-','+','=','_'
        ));
    }
}
