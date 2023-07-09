package org.example.validation.userdata;

import org.example.validation.exceptions.LengthException;
import org.example.validation.exceptions.SyntaxException;

public class ValidateData {
    private final DataProcessor chain;

    private Data request;

    public ValidateData() {
        this.chain = new LengthProcessor(new ValidateProcessor(null));
    }

    public void validate(String name, String surname, String birth) throws Exception {
        this.request = new Data(
                name,
                surname,
                birth
                );
        this.chain.process(this.request);
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
        if (request.isSuitableLength(new int[]{
                DataLen.NAME.len,
                DataLen.SURNAME.len,
                DataLen.BIRTH.len
        })) {
            super.process(request);
        } else {
            throw new LengthException();
        }
    }
}

class ValidateProcessor extends DataProcessor {
    public ValidateProcessor(DataProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void process(Data request) throws Exception {
        if (request.isValidInput()) {
            super.process(request);
        } else {
            throw new SyntaxException();
        }
    }
}
