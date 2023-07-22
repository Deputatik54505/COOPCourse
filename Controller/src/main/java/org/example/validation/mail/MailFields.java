package org.example.validation.mail;

public enum MailFields {
    MIN_LOCAL_PART(1),
    MAX_LOCAL_PART(64),
    MIN_DOMEN_PART(1),
    MAX_DOMEN_PART(255);
    public final int requiredLen;
    MailFields(int len) {
        this.requiredLen = len;
    }
}
