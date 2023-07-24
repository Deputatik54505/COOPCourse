package org.example.validation.userdata;

public class DataName {
    private final String name;

    public DataName(Data data) {
        this.name = data.name;
    }

    public boolean isValidInput() {
        for (int i = 1; i < this.name.length(); i++) {
            if (!(
                    (this.name.charAt(i) >= 'a' &&
                    this.name.charAt(i) <= 'z') ||
                    (this.name.charAt(i) >= 'A' &&
                    this.name.charAt(i) <= 'Z')
            )) {
                return false;
            }
        }
        return true;
    }
}
