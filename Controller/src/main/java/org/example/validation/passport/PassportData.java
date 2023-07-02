package org.example.validation.passport;

public class PassportData {
    protected final String passport;
    private String series;
    private String number;
    public PassportData(String passport) {
        this.passport = passport;
        this.series = "";
        this.number = "";
    }
    public boolean splitData(int lenSer, int lenNum) {
        try {
            this.series = this.passport.substring(0, lenSer);
            this.number = this.passport.substring(lenSer, lenNum);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    public void printData() {
        System.out.println(this.series + " " + this.number);
    }
}
