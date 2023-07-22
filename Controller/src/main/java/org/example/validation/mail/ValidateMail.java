package org.example.validation.mail;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidateMail {
    private final MailProcessor chain;

    public ValidateMail() {
        this.chain = new LengthProcessor(new ValidProcessor(null));
    }

    public void validate(String mail) throws LengthException, SyntaxException {
        this.chain.process(new Mail(mail));
    }
}

abstract class MailProcessor {
    private final MailProcessor nextProcessor;

    public MailProcessor(MailProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Mail request) throws LengthException, SyntaxException {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class LengthProcessor extends MailProcessor {
    public LengthProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws LengthException, SyntaxException {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class ValidProcessor extends MailProcessor {
    public ValidProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws LengthException, SyntaxException {
        if (new SyntacticMail(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
