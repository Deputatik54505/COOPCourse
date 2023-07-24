package org.example.validation.userdata;

import org.example.validation.exceptions.*;

public class ValidateData {
    private final DataProcessor chain;

    public ValidateData() {
        this.chain = new ValidateName(new ValidateSurname(new ValidateBirth(null)));
    }

    public void validate(String name, String surname, String birth) throws Exception {
        this.chain.process(new Data(name, surname, birth));
    }
}

abstract class DataProcessor {
    private final DataProcessor nextProcessor;

    public DataProcessor(DataProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Data request) throws Exception {
        if (this.nextProcessor != null) {
            this.nextProcessor.process(request);
        }
    };
}

class UpNameProcessor extends DataProcessor {
    public UpNameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new NameUpChar(request).isUppercase()) {
            super.process(request);
        } else {
            throw new NameUpCharExc();
        }
    }
}

class UpSurnameProcessor extends DataProcessor {
    public UpSurnameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new SurnameUpChar(request).isUppercase()) {
            super.process(request);
        } else {
            throw new SurnameUpCharExc();
        }
    }
}

class MaxNameProcessor extends DataProcessor {
    public MaxNameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new MaxNameLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxNameExc();
        }
    }
}

class MaxSurnameProcessor extends DataProcessor {
    public MaxSurnameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new MaxSurnameLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MaxSurnameExc();
        }
    }
}

class MinSurnameProcessor extends DataProcessor {
    public MinSurnameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new MinSurnameLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinSurnameExc();
        }
    }
}

class MinNameProcessor extends DataProcessor {
    public MinNameProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new MinNameLen(request).isSuitableLength()) {
            super.process(request);
        } else {
            throw new MinNameExc();
        }
    }
}

class ValidateBirth extends DataProcessor {
    public ValidateBirth(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new DataBirth(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxBirthExc();
        }
    }
}

class ValidateName extends DataProcessor {
    public ValidateName(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new DataName(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxNameExc();
        }
    }
}

class ValidateSurname extends DataProcessor {
    public ValidateSurname(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (new DataSurname(request).isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxSurnameExc();
        }
    }
}
