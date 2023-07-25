package org.example.validation.password;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public final class ValidatePassword {
    private final ArrayList<ICheckPassword> chain;

    private final Password password;

    public ValidatePassword(String password) {
        this.chain = new ArrayList<>();
        this.password = new Password(password);
    }

    public void validate() throws Exception {
        this.password.initLength();
        this.initChain();
        for (ICheckPassword item : this.chain) {
            item.process(this.password);
        }
    }

    private void initChain() {
        this.chain.addAll(Arrays.asList(
                new MinPasswordCheck(),
                new MaxPasswordCheck(),
                new UpCheck(),
                new LowCheck(),
                new NumCheck(),
                new SpecialCheck(),
                new ValidateCheck()
        ));
    }
}

interface ICheckPassword {
    void process(Password request) throws Exception;
}

final class MinPasswordCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new MinPassword(request).isSuitableLength()) {
            throw new MinPasswordExc();
        }
    }
}

final class MaxPasswordCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new MaxPassword(request).isSuitableLength()) {
            throw new MaxPasswordExc();
        }
    }
}

final class UpCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new UpPassword(request).isUpLetter()) {
            throw new UpPasswordExc();
        }
    }
}

final class LowCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new LowPassword(request).isLowLetter()) {
            throw new LowPasswordExc();
        }
    }
}

final class NumCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new NumPassword(request).isNum()) {
            throw new NumPasswordExc();
        }
    }
}

final class SpecialCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new SpecialPassword(request).isSpecialChar()) {
            throw new SpecialPasswordExc();
        }
    }
}

final class ValidateCheck implements ICheckPassword {
    public void process(Password request) throws Exception {
        if (!new SyntacticPassword(request).isValidInput()) {
            throw new SyntaxPasswordExc();
        }
    }
}
