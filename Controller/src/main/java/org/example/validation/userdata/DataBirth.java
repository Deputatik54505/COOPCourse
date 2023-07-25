package org.example.validation.userdata;

import java.util.ArrayList;

public class DataBirth {
    private final Data data;

    private final ArrayList<String> ddmmyyyy;

    private int counter;

    public DataBirth(Data data) {
        this.data = data;
        this.ddmmyyyy = new ArrayList<>(3);
        this.counter = 0;
    }

    public boolean isValidInput() {
        return
                splitBirth(this.data.provideData().get(2)) &&
                isNum(this.ddmmyyyy.get(2)) &&
                isNum(this.ddmmyyyy.get(1)) &&
                isNum(this.ddmmyyyy.get(0));
    }

    private boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    private boolean splitBirth(String birth) {
        for (int i = 0; i < birth.length(); i++) {
            if (birth.charAt(i) == '-') {
                this.counter++;
            }
        }
        if (this.counter != 2) {
            return false;
        }
        this.counter = 0;
        for (int i = 0; i < birth.length(); i++) {
            while (birth.charAt(i) != '.') {
                this.ddmmyyyy.set(this.counter, this.ddmmyyyy.get(this.counter) + birth.charAt(i));
                i++;
            }
            this.counter++;
        }
        return true;
    }
}
