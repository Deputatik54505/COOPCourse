package org.example.validation.password;

import java.util.ArrayList;
import java.util.Arrays;

public final class SyntacticPassword {
    private final Password cPassword;

    private String password;

    private final ArrayList<Character> forbidChars;

    public SyntacticPassword(Password password) {
        this.cPassword = password;
        this.forbidChars = new ArrayList<>();
    }

    public boolean isValidInput() {
        this.initForbidChars();
        this.initData();
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

    private void initData() {
        this.password = this.cPassword.provideData().get(0);
    }
}
