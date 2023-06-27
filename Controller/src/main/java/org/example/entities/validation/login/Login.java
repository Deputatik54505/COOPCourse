package org.example.entities.validation.login;

import org.example.entities.validation.Request;

import java.util.ArrayList;
import java.util.Arrays;

public class Login extends Request {
    private String login;
    private final int maxLen = 16;
    private final ArrayList<Character> forbidChar = new ArrayList<>(Arrays.asList(
            '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
            '<', '>', '&', '#', '$', '^', '@', '"', ' ', '!',
            ',','.',';','-','+','=','_'
    ));
    @Override
    protected boolean isSuitableLength(int len) {
        return this.length >= len && this.length <= this.maxLen;
    }
    @Override
    protected boolean isValidInput() {
        for (int i = 0; i < this.login.length(); i++) {
            for (Character character : this.forbidChar) {
                if (this.login.charAt(i) == character) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isUnique() {
        //TODO: check uniqueness of login
        return true;
    }
}
