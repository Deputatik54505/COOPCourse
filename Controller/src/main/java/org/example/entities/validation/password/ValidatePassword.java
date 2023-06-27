package org.example.entities.validation.password;

import org.example.entities.validation.Processor;

public class ValidatePassword {
    Processor chain;
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

class LengthProcessor extends Processor {
    final int minPassLength = 8;
    public LengthProcessor(Processor nextProcessor) {
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

class LetterProcessor extends Processor {
    public LetterProcessor(Processor nextProcessor) {
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

class NumberProcessor extends Processor {
    public NumberProcessor(Processor nextProcessor) {
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

class ValidateProcessor extends Processor {
    public ValidateProcessor(Processor nextProcessor) {
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
