package org.example.validation.passport;

public enum PassportFields {
    SERIES(4),
    NUMBER(6),
    MIN_PUBLISHER(8),
    MAX_PUBLISHER(64),
    CODE(6);
    public final int requiredLen;
    PassportFields(int len) {
        this.requiredLen = len;
    }
}
