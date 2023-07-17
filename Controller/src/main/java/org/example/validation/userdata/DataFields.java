package org.example.validation.userdata;

public enum DataFields {
    NAME(20),

    SURNAME(20),

    BIRTH(10);

    public final int len;

    DataFields(int len) {
        this.len = len;
    }
}
