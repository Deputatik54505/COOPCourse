package org.example.validation.login;

public class ValidateLogin {
    private LoginProcessor chain;
    public ValidateLogin() {
        this.buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new UniqueProcessor(new ValidateProcessor(null)));
    }
    public void validate(Login login) {
        this.chain.process(login);
    }
}

abstract class LoginProcessor {
    private final LoginProcessor nextProcessor;
    public LoginProcessor(LoginProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };
    public void process(Login request){
        if(nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends LoginProcessor {
    private final int minLogLength = 6;
    public LengthProcessor(LoginProcessor nextProcessor) {
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

class ValidateProcessor extends LoginProcessor {
    public ValidateProcessor(LoginProcessor nextProcessor) {
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

class UniqueProcessor extends LoginProcessor {
    public UniqueProcessor(LoginProcessor nextProcessor) {
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
