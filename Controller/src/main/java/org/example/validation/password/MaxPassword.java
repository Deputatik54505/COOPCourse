package org.example.validation.password;

public final class MaxPassword {
    private final Password password;

    public MaxPassword(Password password) {
        this.password = password;
    }

    public boolean isSuitableLength() {
        return Integer.parseInt(this.password.provideData().get(1)) <= 24;
    }
}
