package org.example.validation.mail;

public class MaxDomenPart {
    private final int domenPart;

    public MaxDomenPart(Mail mail) {
        this.domenPart = mail.domenPart;
    }

    public boolean isSuitableLength() {
        return this.domenPart <= MailFields.MAX_DOMEN_PART.requiredLen;
    }
}
