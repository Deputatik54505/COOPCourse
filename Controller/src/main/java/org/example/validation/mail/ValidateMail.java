package org.example.validation.mail;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidateMail {
    private MailProcessor chain;
    private Mail request;
    public ValidateMail() {
        this.buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new ValidProcessor(null));
    }
    public void validate(String mail) throws Exception {
        this.request = new Mail(mail);
        this.chain.process(this.request);
    }
}

abstract class MailProcessor {
    private final MailProcessor nextProcessor;
    public MailProcessor(MailProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Mail request) throws Exception {
        if(nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends MailProcessor {
    private final int minLogLength = 3;
    public LengthProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Mail request) throws Exception {
        if (request.isSuitableLength(this.minLogLength)) {
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
    public void process(Mail request) throws Exception {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
