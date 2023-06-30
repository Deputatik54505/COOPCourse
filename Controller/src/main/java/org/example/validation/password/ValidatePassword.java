package org.example.validation.password;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidatePassword {
    private PasswordProcessor chain;
    private Password request;
    public ValidatePassword() {
        this.buildChain();
    }
    public void validate(String password) throws Exception {
        this.request = new Password(password);
        this.chain.process(this.request);
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

    public void process(Password request) throws Exception {
        if(nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends PasswordProcessor {
    final int minPassLength = 8;
    public LengthProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) throws Exception {
        if (request.isSuitableLength(this.minPassLength)) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class UpProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public UpProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) throws Exception {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isUpLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class LowProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public LowProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) throws Exception {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isLowLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class NumProcessor extends PasswordProcessor {
    private AlphaChecker alphaChecker;
    public NumProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) throws Exception {
        this.alphaChecker = new AlphaChecker(request);
        if (this.alphaChecker.isNum()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class ValidateProcessor extends PasswordProcessor {
    public ValidateProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Password request) throws Exception {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
