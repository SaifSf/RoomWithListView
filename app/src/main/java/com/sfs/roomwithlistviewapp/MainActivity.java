package com.sfs.roomwithlistviewapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.sfs.roomwithlistviewapp.data.AppDatabase;
import com.sfs.roomwithlistviewapp.data.db.DAO.BookDAO;
import com.sfs.roomwithlistviewapp.data.db.model.Book;
import com.sfs.roomwithlistviewapp.dialog.AddDialog;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements BooksListener {
    private static final String DB_NAME = "Tp4";
    AppDatabase db;
    private BookDAO bookDAO;
    private List<Book> bookList = new ArrayList<>();
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timber.plant(new Timber.DebugTree());
        init();
        ListView listView = findViewById(R.id.list_item);
        adapter = new MyAdapter(this, bookList,this);
        listView.setAdapter(adapter);

//        TextView helloTextView = (TextView) findViewById(R.id.show);
        findViewById(R.id.refresh).setOnClickListener(view -> {
            getAllList();

        });
        findViewById(R.id.btnAdd).setOnClickListener(view -> {
            new AddDialog().AddFormDialog(this, this);
        });
//        findViewById(R.id.get).setOnClickListener(view -> {
//            List<Book> book1 = db.bookDAO().getAllBooks();
//            Timber.d("boook size %s ", book1.size());
//            helloTextView.setText(book1.get(2).getAuteur());
//
//        });

    }

    private void init() {
        Observable.create(emitter -> db = AppDatabase.getInstance(getApplicationContext())).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                }, Timber::e);
    }

    public void addBook(Book book) {
        if (book != null)
            db.bookDAO().insert(book);
    }

    @Override
    public void openModifyDialog(Book book) {

        new AddDialog().showAndModifyDialog(this, this,book);

    }

    @Override
    public void updateBook(Book book) {
        if (book != null)
            Observable.create(emitter -> db.bookDAO().update(book))
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(o -> {
                    }, Timber::e);    }

    @Override
    public void deleteBook(Book book) {

    }

    private void getAllList() {
        bookList = db.bookDAO().getAllBooks();
        adapter.setBooks(bookList);
        adapter.notifyDataSetChanged();
    }


}