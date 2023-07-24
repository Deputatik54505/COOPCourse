package org.example.validation.mail;

public class MaxLocalPart {
    private final int localPart;

    public MaxLocalPart(Mail mail) {
        this.localPart = mail.localPart;
    }

    public boolean isSuitableLength() {
        return this.localPart <= MailFields.MAX_LOCAL_PART.requiredLen;
    }
}
