package org.example.validation.mail;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidateMail {
    private final Mail mail;

    private final ArrayList<ICheck> chain;

    public ValidateMail(String mail) {
        this.chain = new ArrayList<>();
        this.mail = new Mail(mail);
    }

    public void validate() throws Exception {
        this.mail.initLength();
        this.initChain();
        for (ICheck item : this.chain) {
            item.process(this.mail);
        }
    }

    private void initChain() {
        this.chain.addAll(Arrays.asList(
                new MinLocalCheck(),
                new MaxLocalCheck(),
                new MinDomenCheck(),
                new MaxDomenCheck(),
                new ValidCheck()
        ));
    }
}

interface ICheck {
    void process(Mail request) throws Exception;
}

class MinLocalCheck implements ICheck {
    public void process(Mail request) throws Exception {
        if (!new MinLocalPart(request).isSuitableLength()) {
            throw new MinLocalMailExc();
        }
    }
}

class MaxLocalCheck implements ICheck {
    public void process(Mail request) throws Exception {
        if (!new MaxLocalPart(request).isSuitableLength()) {
            throw new MaxLocalMailExc();
        }
    }
}

class MinDomenCheck implements ICheck {
    public void process(Mail request) throws Exception {
        if (!new MinDomenPart(request).isSuitableLength()) {
            throw new MinDomenMailExc();
        }
    }
}

class MaxDomenCheck implements ICheck {
    public void process(Mail request) throws Exception {
        if (!new MaxDomenPart(request).isSuitableLength()) {
            throw new MaxDomenMailExc();
        }
    }
}

class ValidCheck implements ICheck {
    public void process(Mail request) throws Exception {
        if (!new SyntacticMail(request).isValidInput()) {
            throw new SyntaxMailExc();
        }
    }
}
