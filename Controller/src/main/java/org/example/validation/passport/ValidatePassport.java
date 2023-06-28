package org.example.validation.passport;

public class ValidatePassport {
    private PassportProcessor chain;
    public ValidatePassport() {
        this.buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new ValidateProcessor(null));
    }
    public void validate(Passport request) {
        this.chain.process(request);
    }
}

abstract class PassportProcessor {
    private final PassportProcessor nextProcessor;
    public PassportProcessor(PassportProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Passport request){
        if(nextProcessor != null) {
            nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends PassportProcessor {
    final int minPassLength = 8;
    public LengthProcessor(PassportProcessor nextProcessor) {
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

class ValidateProcessor extends PassportProcessor {
    public ValidateProcessor(PassportProcessor nextProcessor) {
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

class CreateProcessor extends PassportProcessor {
    public CreateProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Passport request) {
        if (request.createPassport()) {
            super.process(request);
        } else {
            System.out.println("Error with input data.");
        }
    }
}
