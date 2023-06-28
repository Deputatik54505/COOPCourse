package org.example.validation.mail;

public class ValidateMail {
    private MailProcessor chain;
    public ValidateMail() {
        this.buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new ValidProcessor(null));
    }
    public void validate(Mail request) {
        this.chain.process(request);
    }
}

abstract class MailProcessor {
    private final MailProcessor nextProcessor;
    public MailProcessor(MailProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Mail request){
        if(nextProcessor != null) {
            nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends MailProcessor {
    private final int minLogLength = 3;
    public LengthProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Mail request) {
        if (request.isSuitableLength(this.minLogLength)) {
            super.process(request);
        } else {
            System.out.println("The must must contain at least 3 characters.");
        }
    }
}

class ValidProcessor extends MailProcessor {
    public ValidProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Mail request) {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            System.out.println("The mail has incorrect syntax.");
        }
    }
}
