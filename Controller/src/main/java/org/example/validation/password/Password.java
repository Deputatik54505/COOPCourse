package org.example.validation.password;

import org.example.validation.Request;

public class Password extends Request {
    protected final String password;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
    }

    @Override
    protected boolean isSuitableLength(int[] args) {
        return this.length >= args[0];
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

}
