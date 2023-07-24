package org.example.validation.userdata;

public class MaxSurnameLen {
    private final Data data;

    public MaxSurnameLen(Data data) {
        this.data = data;
    }

    public boolean isSuitableLength() {
        return this.data.provideData().get(1).length() <= 20;
    }
}
