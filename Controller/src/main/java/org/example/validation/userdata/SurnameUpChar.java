package org.example.validation.userdata;

public class SurnameUpChar {
    private final char firstChar;

    public SurnameUpChar(Data data) {
        this.firstChar = data.name.charAt(1);
    }

    public boolean isUppercase() {
        return this.firstChar >= 'A' && this.firstChar <= 'Z';
    }
}
