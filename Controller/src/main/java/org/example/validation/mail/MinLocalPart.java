package org.example.validation.mail;

public class MinLocalPart {
    private final Mail mail;

    public MinLocalPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.provideLength().get(0) >= 1;
    }
}
