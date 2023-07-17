package org.example.validation;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Request {
    protected int length;

    protected final ArrayList<Character> forbidChar = new ArrayList<>(Arrays.asList(
            '?', '/', '%', '*', '(', ')', '[', ']', '{', '}',
            '<', '>', '$', '^', '"', ' ', '!',
            ',','.',';','-','+','=','_'
    ));

    protected abstract boolean isSuitableLength(int[] args);

    protected abstract boolean isValidInput();
}
