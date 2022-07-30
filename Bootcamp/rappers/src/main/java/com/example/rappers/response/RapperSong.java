package com.example.rappers.response;

import com.example.rappers.entity.enums.Type;

public class RapperSong {

    String name;

    Type type;

    String rapperName;

    public RapperSong() {
    }

    public RapperSong(String name, Type type, String rapperName) {
        this.name = name;
        this.type = type;
        this.rapperName = rapperName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getRapper() {
        return rapperName;
    }

    public void setRapper(String rapperName) {
        this.rapperName = rapperName;
    }
}
