package org.example.entities.validation.login;

public class ValidateLogin {
    LProcessor chain;
    public ValidateLogin() {
        buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new UniqueProcessor(new ValidateProcessor(null)));
    }
    public void process(Login request) {
        this.chain.process(request);
    }
}

abstract class LProcessor {
    private final LProcessor nextProcessor;
    public LProcessor(LProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Login request){
        if(nextProcessor != null) {
            nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends LProcessor {
    private final int minLogLength = 6;
    public LengthProcessor(LProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Login request) {
        if (request.isSuitableLength(this.minLogLength)) {
            super.process(request);
        } else {
            System.out.println("The login must contain at least 6 characters and no more than 16 characters.");
        }
    }
}

class ValidateProcessor extends LProcessor {
    public ValidateProcessor(LProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Login request) {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            System.out.println("The login contain forbidden letters.");
        }
    }
}

class UniqueProcessor extends LProcessor {
    public UniqueProcessor(LProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Login request) {
        if (request.isUnique()) {
            super.process(request);
        } else {
            System.out.println("The login must be unique.");
        }
    }
}
