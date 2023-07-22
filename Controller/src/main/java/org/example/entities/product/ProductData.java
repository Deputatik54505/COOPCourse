package org.example.entities.product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    private final float price;
    private final String name;
    private final String description;

    public ProductData(String name, String description, float price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public List<String> represent() {
        List<String> container = new ArrayList<>();
        container.add(name);
        container.add(description);
        container.add(String.format("%.2f", price));
        return container;
    }

    /**
     * Searched for the searching string in the name and description
     *
     * @param search string
     * @return true, if it has that word. Otherwise, false.
     */
    public boolean hasWord(String search) {
        return name.contains(search) || description.contains(search);
    }
}
