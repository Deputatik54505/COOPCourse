package org.example.validation.userdata;

public class MinNameLen {
    private final String name;

    public MinNameLen(Data data) {
        this.name = data.name;
    }

    public boolean isSuitableLength() {
        return this.name.length() >= DataFields.MIN_NAME.requiredLen;
    }
}
