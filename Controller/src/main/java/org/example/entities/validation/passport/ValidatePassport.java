package org.example.entities.validation.passport;

import org.example.entities.validation.Processor;

public class ValidatePassport {
    Processor chain;
    private void buildChain(){
        this.chain = new LengthProcessor(new ExistProcessor(new ValidateProcessor(null)));
    }
    public void process(Passport request) {
        this.chain.process(request);
    }
}

class LengthProcessor extends Processor {
    final int minPassLength = 8;
    public LengthProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Passport request) {
        if (request.isSuitableLength(this.minPassLength)) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least 8 characters.");
        }
    }
}

class ValidateProcessor extends Processor {
    public ValidateProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Passport request) {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            System.out.println("The passport contain forbidden letters.");
        }
    }
}

class ExistProcessor extends Processor {
    public ExistProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Passport request) {
        if (request.isExist()) {
            super.process(request);
        } else {
            System.out.println("The login must be unique.");
        }
    }
}
