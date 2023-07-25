package org.example.validation.userdata;

import org.example.validation.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

public final class ValidateData {
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

final class UpNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new NameUpChar(request).isUppercase()) {
            throw new NameUpCharExc();
        }
    }
}

final class UpSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new SurnameUpChar(request).isUppercase()) {
            throw new SurnameUpCharExc();
        }
    }
}

final class MaxNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new MaxNameLen(request).isSuitableLength()) {
            throw new MaxNameExc();
        }
    }
}

final class MaxSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new MaxSurnameLen(request).isSuitableLength()) {
            throw new MaxSurnameExc();
        }
    }
}

final class MinSurnameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new MinSurnameLen(request).isSuitableLength()) {
            throw new MinSurnameExc();
        }
    }
}

final class MinNameCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new MinNameLen(request).isSuitableLength()) {
            throw new MinNameExc();
        }
    }
}

final class BirthLenCheck implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new BirthLen(request).isSuitableLength()) {
            throw new ExcBirthDataExc();
        }
    }
}

final class ValidateBirth implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new DataBirth(request).isValidInput()) {
            throw new SyntaxBirthExc();
        }
    }
}

final class ValidateName implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new DataName(request).isValidInput()) {
            throw new SyntaxNameExc();
        }
    }
}

final class ValidateSurname implements ICheckData {
    public void process(Data request) throws Exception {
        if (!new DataSurname(request).isValidInput()) {
            throw new SyntaxSurnameExc();
        }
    }
}
