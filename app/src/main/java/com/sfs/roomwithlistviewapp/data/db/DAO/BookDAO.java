package com.sfs.roomwithlistviewapp.data.db.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.sfs.roomwithlistviewapp.data.db.model.Book;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Book book);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);

    @Query("select * FROM livre")
    List<Book> getAllBooks();

    @Query("select * FROM livre where `titre` =:name ")
    Book getBooksByName(String name);
}
