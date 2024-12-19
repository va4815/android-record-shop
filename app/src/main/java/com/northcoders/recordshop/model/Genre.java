package com.northcoders.recordshop.model;

public enum Genre{
    POP(0),
    ROCK(1),
    CLASSICAL(2),
    JAZZ(3),
    BLUES(4),
    FUNK(5)
    ;

    private final int label;

    private Genre(final int label) {
        this.label = label;
    }

}
