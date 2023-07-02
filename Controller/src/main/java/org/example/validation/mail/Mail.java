package org.example.validation.mail;

import org.example.validation.Request;

public class Mail extends Request {
    private final String mail;

    private final SyntacticValidation syntacticValidation;

    public Mail(String mail) {
        this.mail = mail;
        this.syntacticValidation = new SyntacticValidation(this);
        this.length = mail.length();
    }

    @Override
    protected boolean isSuitableLength(int len) {
        return this.length >= len;
    }

    @Override
    protected boolean isValidInput() {
        return this.syntacticValidation.validation(this.mail);
    }
}
