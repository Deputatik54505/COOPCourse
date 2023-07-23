package org.example.validation.userdata;

import org.example.validation.exceptions.LengthDataExc;
import org.example.validation.exceptions.SyntaxBirthExc;
import org.example.validation.exceptions.SyntaxNameExc;
import org.example.validation.exceptions.SyntaxSurnameExc;

public class ValidateData {
    private final DataProcessor chain;

    public ValidateData() {
        this.chain = new LengthProcessor(new ValidateName(new ValidateSurname(new ValidateBirth(null))));
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

class LengthProcessor extends DataProcessor {
    public LengthProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (request.isSuitableLength()) {
            super.process(request);
        } else {
            throw new LengthDataExc();
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
