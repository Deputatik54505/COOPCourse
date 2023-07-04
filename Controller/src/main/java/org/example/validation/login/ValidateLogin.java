package org.example.validation.login;

public class ValidateLogin {
    private LoginProcessor chain;
    public ValidateLogin() {
        this.buildChain();
    }
    private void buildChain(){
        this.chain = new LengthProcessor(new ValidateProcessor(null));
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
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class LengthProcessor extends LoginProcessor {
    private final int minLength = 6;
    private final int maxLength = 16;
    public LengthProcessor(LoginProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void process(Login request) {
        if (request.isSuitableLength(new int[]{this.minLength, this.maxLength})) {
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
