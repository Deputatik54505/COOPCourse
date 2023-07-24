package org.example.validation.userdata;

public class MaxNameLen {
    private final String name;

    public MaxNameLen(Data data) {
        this.name = data.name;
    }

    public boolean isSuitableLength() {
        return this.name.length() <= DataFields.MAX_NAME.requiredLen;
    }
}
