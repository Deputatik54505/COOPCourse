package org.example.validation.userdata;

public class DataName {
    private final Data data;

    private String name;

    public DataName(Data data) {
        this.data = data;
    }

    public boolean isValidInput() {
        this.name = this.data.provideData().get(DataFields.MIN_NAME.ordinal());
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
