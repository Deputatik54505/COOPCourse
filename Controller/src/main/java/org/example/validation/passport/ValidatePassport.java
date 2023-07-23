package org.example.validation.passport;

import org.example.validation.exceptions.*;

public class ValidatePassport {
    private final PassportProcessor chain;

    public ValidatePassport() {
        this.chain = new LengthProcessor(new ValidProcessor(new UpProcessor(new LowProcessor(new NumProcessor(null)))));
    }

    public void validate(String publisher, String code, String series, String number) throws Exception {
        this.chain.process(new Passport(publisher, code, series, number));
    }
}

abstract class PassportProcessor {
    private final PassportProcessor nextProcessor;

    public PassportProcessor(PassportProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Passport request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class LengthProcessor extends PassportProcessor {
    public LengthProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthPassportExc();
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
            throw new SyntaxPassportExc();
        }
    }
}

class UpProcessor extends PassportProcessor {
    public UpProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new UpPassport(request).isUpLetter()) {
            super.process(request);
        } else {
            throw new UpPassportExc();
        }
    }
}

class LowProcessor extends PassportProcessor {
    public LowProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new LowPassport(request).isLowLetter()) {
            super.process(request);
        } else {
            throw new LowPassportExc();
        }
    }
}

class NumProcessor extends PassportProcessor {
    public NumProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new NumPassport(request).isNum()) {
            super.process(request);
        } else {
            throw new NumPassportExc();
        }
    }
}

class SpecialProcessor extends PassportProcessor {
    public SpecialProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new SpecialPassport(request).isSpecialChar()) {
            super.process(request);
        } else {
            throw new SpecialPassportExc();
        }
    }
}
