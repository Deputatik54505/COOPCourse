package org.example.validation.password;

public final class MinPassword {
    private final Password password;

    public MinPassword(Password password) {
        this.password = password;
    }

    public boolean isSuitableLength() {
        return Integer.parseInt(this.password.provideData().get(1)) >= 8;
    }
}
