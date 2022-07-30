package com.example.rappers.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
    RAP,
    JAZZ;

    private String name;

    Type() {
        this.name = name();
    }

    public String getName() {
        return name;
    }

}
