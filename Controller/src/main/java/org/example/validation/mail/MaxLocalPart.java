package org.example.validation.mail;

public class MaxLocalPart {
    private final Mail mail;

    public MaxLocalPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.localPart <= MailFields.MAX_LOCAL_PART.requiredLen;
    }
}