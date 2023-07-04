package org.example.validation.passport;

public class PassportSN {
    private final String series;
    private final String number;
    public PassportSN(String series, String number) {
        this.series = series;
        this.number = number;
    }

    public String printData() {
        return this.series + "&" + this.number;
    }

    public boolean checkLen(int len) {
        return (this.series.length() + this.number.length()) == len;
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
