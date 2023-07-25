package org.example.validation.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntacticMail {
    private final Mail mail;

    private Pattern pattern;

    private Matcher matcher;

    public SyntacticMail(Mail mail) {
        this.mail = mail;
    }

    public boolean isValidInput() {
        this.pattern = Pattern.compile("[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+");
        this.matcher = pattern.matcher(this.mail.provideData().get(0));
        return this.matcher.find();
    }
}
