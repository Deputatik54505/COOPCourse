package org.example.validation.userdata;

public final class MinSurnameLen {
    private final Data data;

    public MinSurnameLen(Data data) {
        this.data = data;
    }

    public boolean isSuitableLength() {
        return this.data.provideData().get(1).length() >= 3;
    }
}
