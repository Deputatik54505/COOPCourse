package org.example.validation.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntacticMail {
    private final String mail;

    private Pattern pattern;

    private Matcher matcher;

    public SyntacticMail(Mail mail) {
        this.mail = mail.userMail;
    }

    public boolean isValidInput() {
        this.pattern = Pattern.compile("[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+");
        this.matcher = pattern.matcher(this.mail);
        return this.matcher.find();
    }
}
