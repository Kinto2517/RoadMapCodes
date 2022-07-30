package com.example.rappers.entity;

import com.example.rappers.entity.enums.Type;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.ALL})
    @JoinColumn(name = "cat_id")
    private Cat cat;


    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.ALL})
    @JoinColumn(name = "rapper_id")
    private Rapper rapper;

    public Song() {
    }

    public Song(Long id, String name, Type type, Cat cat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cat = cat;
    }

    public Song(Long id, String name, Type type, Rapper rapper) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.rapper = rapper;
    }

    public Song(Long id, String name, Type type, Cat cat, Rapper rapper) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.cat = cat;
        this.rapper = rapper;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Rapper getRapper() {
        return rapper;
    }

    public void setRapper(Rapper rapper) {
        this.rapper = rapper;
    }
}