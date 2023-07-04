package org.example.validation.passport;

import org.example.validation.Request;

public class Passport extends Request {

    private final PassportPC passportPC;
    private final PassportSN passportSN;

    public Passport(String publisher, String code,
                    String series, String number) {
        this.passportPC = new PassportPC(publisher, code);
        this.passportSN = new PassportSN(series, number);
    }

    @Override
    protected boolean isSuitableLength(int[] args) {
        return this.passportSN.checkLen(args[0]) && this.passportPC.checkLen(args[1]);
    }

    @Override
    protected boolean isValidInput() {
        return this.passportSN.validate() && this.passportPC.validate();
    }

    public Passport item() {
        return this;
    }
}
