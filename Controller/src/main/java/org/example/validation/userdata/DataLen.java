package org.example.validation.userdata;

public enum DataLen {
    NAME(20),

    SURNAME(20),

    BIRTH(10);

    public final int len;

    DataLen(int len) {
        this.len = len;
    }
}
