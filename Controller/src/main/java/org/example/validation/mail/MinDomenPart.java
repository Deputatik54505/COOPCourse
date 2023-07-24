package org.example.validation.mail;

public class MinDomenPart {
    private final int domenPart;

    public MinDomenPart(Mail mail) {
        this.domenPart = mail.domenPart;
    }

    public boolean isSuitableLength() {
        return this.domenPart >= MailFields.MIN_DOMEN_PART.requiredLen;
    }
}
