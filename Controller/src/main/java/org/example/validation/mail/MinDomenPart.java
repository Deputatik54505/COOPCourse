package org.example.validation.mail;

public class MinDomenPart {
    private final Mail mail;

    public MinDomenPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.provideLength().get(1) >= 1;
    }
}
