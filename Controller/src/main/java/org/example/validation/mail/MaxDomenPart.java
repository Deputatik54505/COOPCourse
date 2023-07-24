package org.example.validation.mail;

public class MaxDomenPart {
    private final Mail mail;

    public MaxDomenPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.domenPart <= MailFields.MAX_DOMEN_PART.requiredLen;
    }
}
