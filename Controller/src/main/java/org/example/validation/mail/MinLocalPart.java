package org.example.validation.mail;

public class MinLocalPart {
    private final int localPart;

    public MinLocalPart(Mail mail) {
        this.localPart = mail.localPart;
    }

    public boolean isSuitableLength() {
        return this.localPart >= MailFields.MIN_LOCAL_PART.requiredLen;
    }
}
