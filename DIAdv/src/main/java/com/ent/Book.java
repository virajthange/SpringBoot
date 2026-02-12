package com.ent;

public class Book {
    int id;
    String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: "+ this.id + " Name: "+ name;
    }
}
