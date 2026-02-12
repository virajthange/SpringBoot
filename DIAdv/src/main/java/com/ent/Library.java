package com.ent;

import java.util.List;

public class Library {
    int id;
    List<Book> books;

    public void setId(int id) {
        this.id = id;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Id: "+ id +"\nBooks: "+ books;
    }
}
