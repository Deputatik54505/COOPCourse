package org.example.entities.validation.password;

import org.example.entities.validation.Request;

import java.util.ArrayList;
import java.util.Arrays;

public class Password extends Request {
    private final String password;
    private final ArrayList<Character> forbidChar = new ArrayList<>(Arrays.asList(
            '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
            '<', '>', '&', '#', '$', '^', '@', '"', ' ', '!',
            ',','.',';','-','+','=','_'
    ));

    public Password(String password) {
        this.password = password;
        this.length = password.length();
    }

    @Override
    protected boolean isSuitableLength(int len) {
        return this.length >= len;
    }

    @Override
    protected boolean isValidInput() {
        for (int i = 0; i < this.password.length(); i++) {
            for (Character character : this.forbidChar) {
                if (this.password.charAt(i) == character) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isConEnLetter() {
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) >= 'A' && this.password.charAt(i) <= 'Z' ||
                    this.password.charAt(i) >= 'a' && this.password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }
    public boolean isConNum() {
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) >= '0' && this.password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
}
