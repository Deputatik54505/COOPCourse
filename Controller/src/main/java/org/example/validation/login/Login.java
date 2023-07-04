package org.example.validation.login;

import org.example.validation.Request;

public class Login extends Request {
    private final String login;
    public Login(String login) {
        this.login = login;
        this.length = login.length();
    }
    @Override
    protected boolean isSuitableLength(int[] args) {
        return this.length >= args[0] && this.length <= args[1];
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
    public Login item() {
        return this;
    }
}
