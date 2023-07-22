package org.example.validation.passport;

public class Passport {
    protected final PassportPC passportPC;

    protected final PassportSN passportSN;

    public Passport(String publisher, String code, String series, String number) {
        this.passportPC = new PassportPC(publisher, code);
        this.passportSN = new PassportSN(series, number);
    }

    public boolean isSuitableLength() {
        return this.passportSN.checkLen() && this.passportPC.checkLen();
    }

    public boolean isValidInput() {
        return this.passportSN.validate() && this.passportPC.validate();
    }

}
