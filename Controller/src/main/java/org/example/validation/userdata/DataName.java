package org.example.validation.userdata;

public class DataName {
    private final Data data;

    public DataName(Data data) {
        this.data = data;
    }

    public boolean isValidInput() {
        return this.validateName(this.data.provideData().get(0));
    }

    private boolean validateName(String name) {
        for (int i = 1; i < name.length(); i++) {
            if (!(
                    (name.charAt(i) >= 'a' &&
                            name.charAt(i) <= 'z') ||
                            (name.charAt(i) >= 'A' &&
                                    name.charAt(i) <= 'Z')
            )) {
                return false;
            }
        }
        return true;
    }
}
