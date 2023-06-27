package org.example.entities.validation.login;

import org.example.entities.validation.Processor;

public class ValidateLogin {
    Processor chain;
    private void buildChain(){
        this.chain = new LengthProcessor(new UniqueProcessor(new ValidateProcessor(null)));
    }
    public void process(Login request) {
        this.chain.process(request);
    }
}

class LengthProcessor extends Processor {
    private final int minLogLength = 6;
    public LengthProcessor(Processor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Login request) {
        if (request.isSuitableLength(this.minLogLength)) {
            super.process(request);
        } else {
            System.out.println("The login must contain at least 6 characters.");
        }
    }
}

class ValidateProcessor extends Processor {
    public ValidateProcessor(Processor nextProcessor) {
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

class UniqueProcessor extends Processor {
    public UniqueProcessor(Processor nextProcessor) {
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
