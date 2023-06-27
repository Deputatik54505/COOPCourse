package org.example.validation;

public abstract class Request {
    protected int length;
    protected abstract boolean isSuitableLength(int len);
    protected abstract boolean isValidInput();
}
