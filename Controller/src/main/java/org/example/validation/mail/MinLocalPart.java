package org.example.validation.mail;

public class MinLocalPart {
    private final Mail mail;

    public MinLocalPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.localPart >= MailFields.MIN_LOCAL_PART.requiredLen;
    }
}
