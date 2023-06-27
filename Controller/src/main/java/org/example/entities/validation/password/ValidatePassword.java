package org.example.entities.validation.password;

public class ValidatePassword {
    PProcessor chain;
    public ValidatePassword() {
        buildChain();
    }
    public void process(Password request) {
        this.chain.process(request);
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new LetterProcessor(new NumberProcessor(new ValidateProcessor(null))));
    }
}

abstract class PProcessor {
    private final PProcessor nextProcessor;

    public PProcessor(PProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Password request){
        if(nextProcessor != null)
            nextProcessor.process(request);
    };
}

class LengthProcessor extends PProcessor {
    final int minPassLength = 8;
    public LengthProcessor(PProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        if (request.isSuitableLength(this.minPassLength)) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least 8 characters.");
        }
    }
}

class LetterProcessor extends PProcessor {
    public LetterProcessor(PProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        if (request.isConEnLetter()) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least one English letter.");
        }
    }
}

class NumberProcessor extends PProcessor {
    public NumberProcessor(PProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        if (request.isConNum()) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least one number.");
        }
    }
}

class ValidateProcessor extends PProcessor {
    public ValidateProcessor(PProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            System.out.println("The password contain forbidden letters.");
        }
    }
}
