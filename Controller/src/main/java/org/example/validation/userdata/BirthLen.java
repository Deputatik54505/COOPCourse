package org.example.validation.userdata;

public class BirthLen {
    private final Data data;

    public BirthLen(Data data) {
        this.data = data;
    }

    public boolean isSuitableLength() {
        return this.data.provideData().get(2).length() == 10;
    }
}
