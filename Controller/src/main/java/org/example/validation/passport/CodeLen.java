package org.example.validation.passport;

public class CodeLen {
    private final String code;

    public CodeLen(Passport passport) {
        this.code = passport.passportPC.code;
    }

    public boolean isSuitableLength() {
        return this.code.length() == PassportFields.CODE.requiredLen;
    }
}
