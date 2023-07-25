package org.example.validation.passport;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public final class ValidatePassport {
    private final ArrayList<ICheckPassport> chain;

    private final Passport passport;

    public ValidatePassport(Passport passport) {
        this.chain = new ArrayList<>();
        this.passport = passport;
    }

    public void validate() throws Exception {
        this.initChain();
        for (ICheckPassport item : this.chain) {
            item.process(this.passport);
        }
    }

    private void initChain() {
        this.chain.addAll(Arrays.asList(
                new SeriesLenCheck(),
                new NumberLenCheck(),
                new MinPublisherCheck(),
                new MaxPublisherCheck(),
                new CodeLenCheck(),
                new UpCheck(),
                new LowCheck(),
                new NumCheck(),
                new ValidCheck(),
                new SpecialCheck()
        ));
    }
}

interface ICheckPassport {
    void process(Passport request) throws Exception;
}

final class CodeLenCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new CodeLen(request).isSuitableLength()) {
            throw new ExcPassportCodeExc();
        }
    }
}

final class SeriesLenCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new SeriesLen(request).isSuitableLength()) {
            throw new ExcPassportSeriesExc();
        }
    }
}

final class NumberLenCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new NumberLen(request).isSuitableLength()) {
            throw new ExcPassportNumberExc();
        }
    }
}

final class MinPublisherCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new MinPublisherLen(request).isSuitableLength()) {
            throw new MinPublisherExc();
        }
    }
}

final class MaxPublisherCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new MaxPublisherLen(request).isSuitableLength()) {
            throw new MaxPublisherExc();
        }
    }
}

final class ValidCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!request.isValidInput()) {
            throw new SyntaxPassportExc();
        }
    }
}

final class UpCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new UpPassport(request).isUpLetter()) {
            throw new UpPassportExc();
        }
    }
}

final class LowCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new LowPassport(request).isLowLetter()) {
            throw new LowPassportExc();
        }
    }
}

final class NumCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new NumPassport(request).isNum()) {
            throw new NumPassportExc();
        }
    }
}

final class SpecialCheck implements ICheckPassport {
    public void process(Passport request) throws Exception {
        if (!new SpecialPassport(request).isSpecialChar()) {
            throw new SpecialPassportExc();
        }
    }
}
