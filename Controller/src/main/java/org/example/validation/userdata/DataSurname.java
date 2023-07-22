package org.example.validation.userdata;

public class DataSurname {
    private final Data data;

    private String surname;

    public DataSurname(Data data) {
        this.data = data;
    }

    public boolean isValid() {
        this.surname = this.data.represent().get(DataFields.SURNAME.ordinal());
        for (int i = 0; i < this.surname.length(); i++) {
            if (!(
                    (this.surname.charAt(i) >= 'a' &&
                    this.surname.charAt(i) <= 'z') ||
                    (this.surname.charAt(i) >= 'A' &&
                    this.surname.charAt(i) <= 'Z')
            )) {
                return false;
            }
        }
        return true;
    }
}
