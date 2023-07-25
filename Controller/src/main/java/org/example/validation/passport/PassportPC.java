package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public final class PassportPC {
    private final String publisher;

    private final String code;

    private final ArrayList<Character> forbidChars;

    public PassportPC(String publisher, String code) {
        this.publisher = publisher;
        this.code = code;
        this.forbidChars = new ArrayList<>();
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(this.publisher, this.code));
    }

    public boolean isValid() {
        for (int i = 0; i < this.code.length(); i++) {
            if (!(this.code.charAt(i) >= '0' &&
                    this.code.charAt(i) <= '9')) {
                return false;
            }
        }
        for (int i = 0; i < this.publisher.length(); i++) {
            for (Character character : this.forbidChars) {
                if (this.publisher.charAt(i) == character) {
                    return false;
                }
            }
        }
        return true;
    }

    private void initForbidChars() {
        this.forbidChars.addAll(Arrays.asList(
                '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
                '<', '>', '$', '^', '"', '!',
                ';','+','=','_'
        ));
    }
}
