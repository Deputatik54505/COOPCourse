package org.example.validation.userdata;

public enum DataFields {
    MIN_NAME(3),
    MIN_SURNAME(3),
    BIRTH(10),
    MAX_NAME(20),
    MAX_SURNAME(20);
    public final int requiredLen;
    DataFields(int len) {
        this.requiredLen = len;
    }
}
