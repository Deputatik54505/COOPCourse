package org.example.validation.passport;

public class PassportPC {
    private final String publisher;

    private final String code;

    public PassportPC(String publisher, String code) {
        this.publisher = publisher;
        this.code = code;
    }

    public String printData() {
        return this.publisher + "&" + this.code;
    }

    public boolean checkLen(int len) {
        return this.code.length() == len;
    }

    public boolean validate() {
        for (int i = 0; i < this.code.length(); i++) {
            if (!(this.code.charAt(i) >= '0' &&
                    this.code.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
}
