package org.example.validation.password;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidatePassword {
    private final PasswordProcessor chain;

    private Password request;

    public ValidatePassword() {
        this.chain = new LengthProcessor(new LowProcessor(new UpProcessor(new NumProcessor(new ValidateProcessor(new SpecialProcessor(null))))));
    }

    public void validate(String password) throws Exception {
        this.request = new Password(password);
        this.chain.process(this.request);
    }
}

abstract class PasswordProcessor {
    private final PasswordProcessor nextProcessor;

    public PasswordProcessor(PasswordProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Password request) throws Exception {
        if (this.nextProcessor != null) {
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
        if (request.isSuitableLength(new int[]{this.minPassLength})) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class UpProcessor extends PasswordProcessor {
    private UpPassword upPassword;

    public UpProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        this.upPassword = new UpPassword(request);
        if (this.upPassword.isUpLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class LowProcessor extends PasswordProcessor {
    private LowPassword lowPassword;

    public LowProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        this.lowPassword = new LowPassword(request);
        if (this.lowPassword.isLowLetter()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class NumProcessor extends PasswordProcessor {
    private NumPassword numPassword;

    public NumProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        this.numPassword = new NumPassword(request);
        if (this.numPassword.isNum()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}

class SpecialProcessor extends PasswordProcessor {
    private SpecialPassword specialPassword;

    public SpecialProcessor(PasswordProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Password request) throws Exception {
        this.specialPassword = new SpecialPassword(request);
        if (this.specialPassword.isSpecialChar()) {
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
