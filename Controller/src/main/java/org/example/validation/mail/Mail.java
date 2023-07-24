package org.example.validation.mail;

public class Mail {
    protected final String userMail;

    protected int localPart;

    protected int domenPart;


    public Mail(String mail) {
        this.userMail = mail;
        this.localPart = 0;
        this.domenPart = 0;
    }

    public void initLength() {
        this.localPartLen();
        this.domenPartLen();
    }

    private void localPartLen() {
        for (int i = 0; i < this.userMail.length(); i++) {
            if (this.userMail.charAt(i) == '@') {
                break;
            }
            this.localPart++;
        }
    }

    private void domenPartLen() {
        for (int i = this.userMail.length() - 1; i >= 0; i--) {
            if (this.userMail.charAt(i) == '@') {
                break;
            }
            this.domenPart++;
        }
    }
}
