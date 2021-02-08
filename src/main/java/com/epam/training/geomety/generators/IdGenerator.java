package com.epam.training.geomety.generators;

public class IdGenerator {
    private int counter;

    public IdGenerator() {
        counter = 1;
    }

    public int nextId() {
        return counter++;
    }
}
