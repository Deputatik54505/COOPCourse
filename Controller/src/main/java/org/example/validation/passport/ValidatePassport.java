package org.example.validation.passport;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidatePassport {
    private final PassportProcessor chain;

    private Passport request;

    public ValidatePassport() {
        this.chain = new LengthProcessor(new ValidProcessor(null));
    }

    public void validate(String publisher, String code,
                         String series, String number) throws Exception {
        this.request = new Passport(publisher, code,
                series, number);
        this.chain.process(this.request);
    }
}

abstract class PassportProcessor {
    private final PassportProcessor nextProcessor;

    public PassportProcessor(PassportProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Passport request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends PassportProcessor {
    private final int lenSN = 10;

    private final int lenC = 6;

    public LengthProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (request.isSuitableLength(new int[]{this.lenSN, this.lenC})) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class ValidProcessor extends PassportProcessor {
    public ValidProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
