package org.example.validation.mail;

public class Mail {
    protected final String userMail;

    private int localPart;

    private int domenPart;


    public Mail(String mail) {
        this.userMail = mail;
        this.localPart = 0;
        this.domenPart = 0;
    }

    public boolean isSuitableLength() {
        this.localPartLen();
        this.domenPartLen();

        return
                this.localPart >= MailFields.MIN_LOCAL_PART.requiredLen &&
                this.localPart <= MailFields.MAX_LOCAL_PART.requiredLen &&
                this.domenPart >= MailFields.MIN_DOMEN_PART.requiredLen &&
                this.domenPart <= MailFields.MAX_DOMEN_PART.requiredLen;
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
