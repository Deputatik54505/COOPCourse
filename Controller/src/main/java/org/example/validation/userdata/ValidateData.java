package org.example.validation.userdata;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidateData {
    private final ArrayList<ICheckData> chain;
    
    private final Data data;

    public ValidateData(Data data) {
        this.chain = new ArrayList<>();
        this.data = data;
    }

    public void validate() throws Exception {
        this.initChain();
        for (ICheckData item : this.chain) {
            item.process(this.data);
        }
    }

    private void initChain() {
        this.chain.addAll(Arrays.asList(
                new UpNameCheck(),
                new UpSurnameCheck(),
                new MinNameCheck(),
                new MaxNameCheck(),
                new MinSurnameCheck(),
                new MaxSurnameCheck(),
                new BirthLenCheck(),
                new ValidateName(),
                new ValidateSurname(),
                new ValidateBirth()
        ));
    }
}

interface ICheckData {
    void process(Data request) throws Exception;
}

class UpNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new NameUpChar(request).isUppercase()) {
            throw new NameUpCharExc();
        }
    }
}

class UpSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new SurnameUpCharExc();
        }
    }
}

class MaxNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new MaxNameExc();
        }
    }
}

class MaxSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new MaxSurnameExc();
        }
    }
}

class MinSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new MinSurnameExc();
        }
    }
}

class MinNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new MinNameExc();
        }
    }
}

class BirthLenCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new BirthLen(request).isSuitableLength()) {
            throw new ExcBirthDataExc();
        }
    }
}

class ValidateBirth implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new SyntaxBirthExc();
        }
    }
}

class ValidateName implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new SyntaxNameExc();
        }
    }
}

class ValidateSurname implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new SyntaxSurnameExc();
        }
    }
}
