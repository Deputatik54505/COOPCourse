package org.example.validation.userdata;

public final class MinNameLen {
    private final Data data;

    public MinNameLen(Data data) {
        this.data = data;
    }

    public boolean isSuitableLength() {
        return this.data.provideData().get(0).length() >= 3;
    }
}
