package org.example.validation.userdata;

public class BirthLen {
    private final String birth;

    public BirthLen(Data data) {
        this.birth = data.birth;
    }

    public boolean isSuitableLength() {
        return this.birth.length() == DataFields.BIRTH.requiredLen;
    }
}
