package org.example.validation.password;

import org.example.validation.exceptions.*;

public class ValidatePassword {
    private final PasswordProcessor chain;

    public ValidatePassword() {
        this.chain = new LengthProcessor(new LowProcessor(new UpProcessor(new NumProcessor(new ValidateProcessor(new SpecialProcessor(null))))));
    }

    public void validate(String password) throws Exception {
        this.chain.process(new Password(password));
    }
}

abstract class PasswordProcessor {
    private final PasswordProcessor nextProcessor;

    public PasswordProcessor(PasswordProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Password request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class LengthProcessor extends PasswordProcessor {
    public LengthProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthPasswordExc();
        }
    }
}

class UpProcessor extends PasswordProcessor {
    public UpProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new UpPassword(request).isUpLetter()) {
            super.process(request);
        } else {
            throw new UpPasswordExc();
        }
    }
}

class LowProcessor extends PasswordProcessor {
    public LowProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new LowPassword(request).isLowLetter()) {
            super.process(request);
        } else {
            throw new LowPasswordExc();
        }
    }
}

class NumProcessor extends PasswordProcessor {
    public NumProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new NumPassword(request).isNum()) {
            super.process(request);
        } else {
            throw new NumPasswordExc();
        }
    }
}

class SpecialProcessor extends PasswordProcessor {
    public SpecialProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new SpecialPassword(request).isSpecialChar()) {
            super.process(request);
        } else {
            throw new SpecialPasswordExc();
        }
    }
}

class ValidateProcessor extends PasswordProcessor {
    public ValidateProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new SyntacticPassword(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxPasswordExc();
        }
    }
}
