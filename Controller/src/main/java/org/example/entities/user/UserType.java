package org.example.entities.user;

public final class UserType {
    private final String type;

    public UserType(String type) {
        this.type = type;
    }

    public boolean isBuyer() {
        return type.equals("Buyer");
    }

    public boolean isSeller() {
        return type.equals("Seller");
    }
}
