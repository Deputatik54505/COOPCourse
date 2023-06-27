package org.example.entities.validation.passport;

public class ValidatePassport {
    PProcessor chain;
    public ValidatePassport() {
        buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new ExistProcessor(new ValidateProcessor(null)));
    }
    public void process(Passport request) {
        this.chain.process(request);
    }
}

abstract class PProcessor {
    private final PProcessor nextProcessor;
    public PProcessor(PProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Passport request){
        if(nextProcessor != null)
            nextProcessor.process(request);
    };
}

class LengthProcessor extends PProcessor {
    final int minPassLength = 8;
    public LengthProcessor(PProcessor nextProcessor) {
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

class ValidateProcessor extends PProcessor {
    public ValidateProcessor(PProcessor nextProcessor) {
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

class ExistProcessor extends PProcessor {
    public ExistProcessor(PProcessor nextProcessor) {
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
