package com.job4j.employeeslist;

import java.io.Serializable;

public class Profession implements Serializable {

    private String name;
    private int id;

    public Profession(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
