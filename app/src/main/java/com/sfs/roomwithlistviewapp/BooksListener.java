package com.sfs.roomwithlistviewapp;

import com.sfs.roomwithlistviewapp.data.db.model.Book;

public interface BooksListener {
    void addBook(Book book);

    void openModifyDialog(Book book);

    void updateBook(Book book);

    void deleteBook(Book book);
}
