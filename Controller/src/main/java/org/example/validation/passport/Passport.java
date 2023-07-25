package org.example.validation.passport;

import org.example.forms.passport.PassportVerification;

import java.util.ArrayList;

public final class Passport {
    private final PassportSN passportSN;

    private final PassportPC passportPC;

    private final ArrayList<String> data;

    public Passport(String series, String number, String publisher, String code) {
        this.passportSN = new PassportSN(series, number);
        this.passportPC = new PassportPC(publisher, code);
        this.data = new ArrayList<>();
    }

    public ArrayList<String> provideData() {
        this.data.addAll(this.passportSN.provideData());
        this.data.addAll(this.passportPC.provideData());

        return this.data;
    }

    public void selfValidation() throws Exception {
        //TODO refactor passport validation
        new PassportVerification(this).verifyPassport();
    }

    public boolean isValidInput() {
        return this.passportSN.isValid() && this.passportPC.isValid();
    }

}
