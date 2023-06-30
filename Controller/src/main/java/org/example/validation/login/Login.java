package org.example.validation.login;

import org.example.validation.Request;

public class Login extends Request {
    private final String login;
    private final int maxLen = 16;
    public Login(String login) {
        this.login = login;
        this.length = login.length();
    }
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
