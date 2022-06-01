package com.github.clarakraus.stspringexperience;

import java.util.UUID;

public class Student {
    public Student(String name) {
        this.name = name;
    }

    private String name;
    private String id = UUID.randomUUID().toString();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
