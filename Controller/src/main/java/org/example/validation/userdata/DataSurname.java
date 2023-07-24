package org.example.validation.userdata;

public class DataSurname {
    private final String surname;

    public DataSurname(Data data) {
        this.surname = data.surname;
    }

    public boolean isValidInput() {
        for (int i = 1; i < this.surname.length(); i++) {
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
