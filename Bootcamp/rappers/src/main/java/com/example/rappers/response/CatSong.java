package com.example.rappers.response;

import com.example.rappers.entity.enums.Type;

public class CatSong {

    String name;

    Type type;

    String catName;

    public CatSong() {
    }

    public CatSong(String name, Type type, String catName) {
        this.name = name;
        this.type = type;
        this.catName = catName;
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

    public String getCat() {
        return catName;
    }

    public void setCat(String catName) {
        this.catName = catName;
    }
}
