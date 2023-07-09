package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public class PassportPC {
    protected final String publisher;

    private final String code;

    private final ArrayList<Character> forbidChar = new ArrayList<>(Arrays.asList(
            '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
            '<', '>', '&', '#', '$', '^', '@', '"', '!',
            ';','+','=','_'
    ));

    public PassportPC(String publisher, String code) {
        this.publisher = publisher;
        this.code = code;
    }

    public String printData() {
        return this.publisher + "&" + this.code;
    }

    public boolean checkLen(int len) {
        return this.code.length() == len;
    }

    public boolean validate() {
        for (int i = 0; i < this.code.length(); i++) {
            if (!(this.code.charAt(i) >= '0' &&
                    this.code.charAt(i) <= '9')) {
                return false;
            }
        }
        for (int i = 0; i < this.publisher.length(); i++) {
            for (Character character : this.forbidChar) {
                if (this.publisher.charAt(i) == character) {
                    return false;
                }
            }
        }
        return true;
    }
}
