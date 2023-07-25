package org.example.validation.mail;

import java.util.ArrayList;
import java.util.Arrays;

public final class Mail {
    private final String userMail;

    private int localPart;

    private int domenPart;


    public Mail(String mail) {
        this.userMail = mail;
        this.localPart = 0;
        this.domenPart = 0;
    }

    public void initLength() {
        for (int i = 0; i < this.userMail.length(); i++) {
            if (this.userMail.charAt(i) == '@') {
                break;
            }
            this.localPart++;
        }
        for (int i = this.userMail.length() - 1; i >= 0; i--) {
            if (this.userMail.charAt(i) == '@') {
                break;
            }
            this.domenPart++;
        }
    }

    public ArrayList<String> provideData() {
        return new ArrayList<>(Arrays.asList(
                this.userMail,
                Integer.toString(this.localPart),
                Integer.toString(this.domenPart)
        ));
    }

    public ArrayList<Integer> provideLength() {
        return new ArrayList<>(Arrays.asList(this.localPart, this.domenPart));
    }
}
