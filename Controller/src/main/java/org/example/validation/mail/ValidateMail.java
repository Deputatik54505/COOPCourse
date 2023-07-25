package org.example.validation.mail;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public final class ValidateMail {
    private final Mail mail;

    private final ArrayList<ICheckMail> chain;

    public ValidateMail(String mail) {
        this.chain = new ArrayList<>();
        this.mail = new Mail(mail);
    }

    public void validate() throws Exception {
        this.mail.initLength();
        this.initChain();
        for (ICheckMail item : this.chain) {
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

interface ICheckMail {
    void process(Mail request) throws Exception;
}

final class MinLocalCheck implements ICheckMail {
    public void process(Mail request) throws Exception {
        if (!new MinLocalPart(request).isSuitableLength()) {
            throw new MinLocalMailExc();
        }
    }
}

final class MaxLocalCheck implements ICheckMail {
    public void process(Mail request) throws Exception {
        if (!new MaxLocalPart(request).isSuitableLength()) {
            throw new MaxLocalMailExc();
        }
    }
}

final class MinDomenCheck implements ICheckMail {
    public void process(Mail request) throws Exception {
        if (!new MinDomenPart(request).isSuitableLength()) {
            throw new MinDomenMailExc();
        }
    }
}

final class MaxDomenCheck implements ICheckMail {
    public void process(Mail request) throws Exception {
        if (!new MaxDomenPart(request).isSuitableLength()) {
            throw new MaxDomenMailExc();
        }
    }
}

final class ValidCheck implements ICheckMail {
    public void process(Mail request) throws Exception {
        if (!new SyntacticMail(request).isValidInput()) {
            throw new SyntaxMailExc();
        }
    }
}
