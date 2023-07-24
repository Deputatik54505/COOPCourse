package org.example.validation.password;

import org.example.validation.exceptions.*;

public class ValidatePassword {
    private final PasswordProcessor chain;

    private final Password password;

    public ValidatePassword(String password) {
        this.chain = new MinPasswordProcessor(new MaxPasswordProcessor(new LowProcessor(new UpProcessor(new NumProcessor(new ValidateProcessor(new SpecialProcessor(null)))))));
        this.password = new Password(password);
    }

    public void validate() throws Exception {
        this.password.initLength();
        this.chain.process(this.password);
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

class MinPasswordProcessor extends PasswordProcessor {
    public MinPasswordProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new MinPassword(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinPasswordExc();
        }
    }
}

class MaxPasswordProcessor extends PasswordProcessor {
    public MaxPasswordProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        if (new MaxPassword(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxPasswordExc();
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
