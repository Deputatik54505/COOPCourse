package org.example.validation.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntacticValidation {
    private final String mail;

    private Pattern pattern;

    private Matcher matcher;

    public SyntacticValidation(String mail) {
        this.mail = mail;
    }

    public boolean validation() {
        this.pattern = Pattern.compile("[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+");
        this.matcher = pattern.matcher(this.mail);
        return this.matcher.find();
    }
}
