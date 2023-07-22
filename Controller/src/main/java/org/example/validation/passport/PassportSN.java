package org.example.validation.passport;

public class PassportSN {
    private final String series;

    private final String number;

    public PassportSN(String series, String number) {
        this.series = series;
        this.number = number;
    }

    public boolean checkLen() {
        return
                this.series.length() == PassportFields.SERIES.requiredLen &&
                this.number.length() == PassportFields.NUMBER.requiredLen;
    }

    public boolean validate() {
        for (int i = 0; i < this.series.length(); i++) {
            if (!(this.series.charAt(i) >= '0' &&
                    this.series.charAt(i) <= '9')) {
                return false;
            }
        }
        for (int i = 0; i < this.number.length(); i++) {
            if (!(this.number.charAt(i) >= '0' &&
                    this.number.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }
}
