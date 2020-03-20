package com.example.parsers.builder;

import candies.Candy;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBuilder {
    protected Set<Candy> candies;
    public AbstractBuilder() {
        candies = new HashSet<Candy>();
    }
    public AbstractBuilder(Set<Candy> candies) {
        this.candies = candies;
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    abstract public void buildSetCandies(String fileName);
}
