package org.example.validation.userdata;

public class NameUpChar {
    private final Data data;

    public NameUpChar(Data data) {
        this.data = data;
    }

    public boolean isUppercase() {
        return this.validateName(this.data.provideData().get(0));
    }

    private boolean validateName(String name) {
        return name.charAt(0) >= 'A' && name.charAt(0) <= 'Z';
    }
}
