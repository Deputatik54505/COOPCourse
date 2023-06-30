package org.example.validation.mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntacticValidation {
    private final Mail cMail;
    private Pattern pattern;
    private Matcher matcher;
    public SyntacticValidation(Mail mail) {
        this.cMail = mail;
    }
    public boolean validation(String mail) {
        this.pattern = Pattern.compile("[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+");
        this.matcher = pattern.matcher(mail);
        return this.matcher.find();
    }
}
