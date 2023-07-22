package org.example.validation.password;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidatePassword {
    private final PasswordProcessor chain;

    public ValidatePassword() {
        this.chain = new LengthProcessor(new LowProcessor(new UpProcessor(new NumProcessor(new ValidateProcessor(new SpecialProcessor(null))))));
    }

    public void validate(String password) throws LengthException, SyntaxException {
        this.chain.process(new Password(password));
    }
}

abstract class PasswordProcessor {
    private final PasswordProcessor nextProcessor;

    public PasswordProcessor(PasswordProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class LengthProcessor extends PasswordProcessor {
    public LengthProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class UpProcessor extends PasswordProcessor {
    public UpProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (new UpPassword(request).isUpLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class LowProcessor extends PasswordProcessor {
    public LowProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (new LowPassword(request).isLowLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class NumProcessor extends PasswordProcessor {
    public NumProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (new NumPassword(request).isNum()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class SpecialProcessor extends PasswordProcessor {
    public SpecialProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws LengthException, SyntaxException {
        if (new SpecialPassword(request).isSpecialChar()) {
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

    public void process(Password request) throws LengthException, SyntaxException {
        if (new SyntacticPassword(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
