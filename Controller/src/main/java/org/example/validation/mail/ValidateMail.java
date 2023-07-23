package org.example.validation.mail;

import org.example.validation.exceptions.LengthMailExc;
import org.example.validation.exceptions.SyntaxMailExc;

public class ValidateMail {
    private final MailProcessor chain;

    public ValidateMail() {
        this.chain = new LengthProcessor(new ValidProcessor(null));
    }

    public void validate(String mail) throws Exception {
        this.chain.process(new Mail(mail));
    }
}

abstract class MailProcessor {
    private final MailProcessor nextProcessor;

    public MailProcessor(MailProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Mail request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class LengthProcessor extends MailProcessor {
    public LengthProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthMailExc();
        }
    }
}

class ValidProcessor extends MailProcessor {
    public ValidProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new SyntacticMail(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxMailExc();
        }
    }
}
