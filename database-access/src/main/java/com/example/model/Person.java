package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final long id;
    private final String name;

    public Person(@JsonProperty("id") long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
