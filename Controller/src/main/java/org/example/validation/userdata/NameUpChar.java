package org.example.validation.userdata;

public class NameUpChar {
    private final char firstChar;

    public NameUpChar(Data data) {
        this.firstChar = data.name.charAt(0);
    }

    public boolean isUppercase() {
        return this.firstChar >= 'A' && this.firstChar <= 'Z';
    }
}
