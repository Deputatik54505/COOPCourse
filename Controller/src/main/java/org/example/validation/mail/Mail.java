package org.example.validation.mail;

import org.example.entities.user.Users;
import org.example.validation.Request;

public class Mail extends Request {
    private final String mail;

    private final Users users;

    private final SyntacticValidation syntacticValidation;

    public Mail(String mail, Users users) {
        this.mail = mail;
        this.users = users;
        this.syntacticValidation = new SyntacticValidation(mail);
        this.length = mail.length();
    }

    @Override
    protected boolean isSuitableLength(int[] args) {
        return this.length >= args[0];
    }

    @Override
    protected boolean isValidInput() {
        return this.syntacticValidation.validation();
    }

    public boolean isUnique() {
        try {
            this.users.findUser(this.mail);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
