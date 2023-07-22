package org.example.validation.userdata;

public class DataName {
    private final Data data;

    private String name;

    public DataName(Data data) {
        this.data = data;
    }

    public boolean isValid() {
        this.name = this.data.represent().get(DataFields.NAME.ordinal());
        for (int i = 0; i < this.name.length(); i++) {
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
