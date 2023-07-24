package org.example.validation.passport;

public class PassportSN {
    protected final String series;

    protected final String number;

    public PassportSN(String series, String number) {
        this.series = series;
        this.number = number;
    }

    public boolean isValid() {
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
