package org.example.validation.mail;

public class MaxDomenPart {
    private final Mail mail;

    public MaxDomenPart(Mail mail) {
        this.mail = mail;
    }

    public boolean isSuitableLength() {
        return this.mail.provideLength().get(1) <= 255;
    }
}
