package ru.domain.netology;

import java.util.Objects;

public class Tshirt extends Product {
    private String label;

    public Tshirt(int id, String name, int price, String label) {
        super(id, name, price);
        this.label = label;
    }
}
