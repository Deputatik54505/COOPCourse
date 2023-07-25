package org.example.validation.userdata;

public class MaxNameLen {
    private final Data data;

    public MaxNameLen(Data data) {
        this.data = data;
    }

    public boolean isSuitableLength() {
        return this.data.provideData().get(0).length() <= 20;
    }
}
