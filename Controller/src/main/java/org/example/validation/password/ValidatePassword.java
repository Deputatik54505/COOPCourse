package org.example.validation.password;

public class ValidatePassword {
    private PasswordProcessor chain;
    public ValidatePassword() {
        this.buildChain();
    }
    public void process(Password request) {
        this.chain.process(request);
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new LowProcessor(new UpProcessor(new NumProcessor(new ValidateProcessor(null)))));
    }
}

abstract class PasswordProcessor {
    private final PasswordProcessor nextProcessor;

    public PasswordProcessor(PasswordProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Password request){
        if(nextProcessor != null) {
            nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends PasswordProcessor {
    final int minPassLength = 8;
    public LengthProcessor(PasswordProcessor nextProcessor) {
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

class UpProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public UpProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isUpLetter()) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least one uppercase character.");
        }
    }
}

class LowProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public LowProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isLowLetter()) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least one lowercase character.");
        }
    }
}

class NumProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public NumProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isNum()) {
            super.process(request);
        } else {
            System.out.println("The password must contain at least one number character.");
        }
    }
}

class ValidateProcessor extends PasswordProcessor {
    public ValidateProcessor(PasswordProcessor nextProcessor) {
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
