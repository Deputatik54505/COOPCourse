package org.example.validation.passport;

import java.util.ArrayList;
import java.util.Arrays;

public final class PassportSN {
    private final String series;

    private final String number;

    public PassportSN(String series, String number) {
        this.series = series;
        this.number = number;
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(this.series, this.number));
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
