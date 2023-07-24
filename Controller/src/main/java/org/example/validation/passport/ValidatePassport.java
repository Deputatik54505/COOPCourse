package org.example.validation.passport;

import org.example.validation.exceptions.*;

public class ValidatePassport {
    private final PassportProcessor chain;

    public ValidatePassport() {
        this.chain = new ValidProcessor(new UpProcessor(new LowProcessor(new NumProcessor(null))));
    }

    public void validate(String publisher, String code, String series, String number) throws Exception {
        this.chain.process(new Passport(publisher, code, series, number));
    }
}

abstract class PassportProcessor {
    private final PassportProcessor nextProcessor;

    public PassportProcessor(PassportProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    }

    public void process(Passport request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    }
}

class CodeLenProcessor extends PassportProcessor {
    public CodeLenProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new CodeLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new ExcPassportCodeExc();
        }
    }
}

class SeriesLenProcessor extends PassportProcessor {
    public SeriesLenProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new SeriesLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new ExcPassportSeriesExc();
        }
    }
}

class NumberLenProcessor extends PassportProcessor {
    public NumberLenProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new NumberLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new ExcPassportNumberExc();
        }
    }
}

class MinPublisherProcessor extends PassportProcessor {
    public MinPublisherProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new MinPublisherLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinPublisherExc();
        }
    }
}

class MaxPublisherProcessor extends PassportProcessor {
    public MaxPublisherProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new MaxPublisherLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxPublisherExc();
        }
    }
}

class ValidProcessor extends PassportProcessor {
    public ValidProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxPassportExc();
        }
    }
}

class UpProcessor extends PassportProcessor {
    public UpProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new UpPassport(request).isUpLetter()) {
            super.process(request);
        } else {
            throw new UpPassportExc();
        }
    }
}

class LowProcessor extends PassportProcessor {
    public LowProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new LowPassport(request).isLowLetter()) {
            super.process(request);
        } else {
            throw new LowPassportExc();
        }
    }
}

class NumProcessor extends PassportProcessor {
    public NumProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new NumPassport(request).isNum()) {
            super.process(request);
        } else {
            throw new NumPassportExc();
        }
    }
}

class SpecialProcessor extends PassportProcessor {
    public SpecialProcessor(PassportProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Passport request) throws Exception {
        if (new SpecialPassport(request).isSpecialChar()) {
            super.process(request);
        } else {
            throw new SpecialPassportExc();
        }
    }
}
