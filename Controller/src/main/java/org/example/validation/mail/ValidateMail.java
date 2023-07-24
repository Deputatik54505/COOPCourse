package org.example.validation.mail;

import org.example.validation.exceptions.*;

public class ValidateMail {
    private final MailProcessor chain;

    private final Mail mail;

    public ValidateMail(String mail) {
        this.chain = new MinLocalProcessor(new MaxLocalProcessor(new MinDomenProcessor(new MaxDomenProcessor(new ValidProcessor(null)))));
        this.mail = new Mail(mail);
    }

    public void validate() throws Exception {
        this.mail.initLength();
        this.chain.process(this.mail);
    }
}

abstract class MailProcessor {
    private final MailProcessor nextProcessor;

    public MailProcessor(MailProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Mail request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class MinLocalProcessor extends MailProcessor {
    public MinLocalProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new MinLocalPart(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinLocalMailExc();
        }
    }
}

class MaxLocalProcessor extends MailProcessor {
    public MaxLocalProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new MaxLocalPart(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxLocalMailExc();
        }
    }
}

class MinDomenProcessor extends MailProcessor {
    public MinDomenProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new MinDomenPart(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinDomenMailExc();
        }
    }
}

class MaxDomenProcessor extends MailProcessor {
    public MaxDomenProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new MaxDomenPart(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxDomenMailExc();
        }
    }
}

class ValidProcessor extends MailProcessor {
    public ValidProcessor(MailProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Mail request) throws Exception {
        if (new SyntacticMail(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxMailExc();
        }
    }
}
