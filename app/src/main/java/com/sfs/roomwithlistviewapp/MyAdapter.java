package com.sfs.roomwithlistviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sfs.roomwithlistviewapp.data.db.model.Book;

import java.util.List;

import timber.log.Timber;

public class MyAdapter extends BaseAdapter {
    private List<Book> books;
    private Context context;
    private BooksListener booksListener;

    public MyAdapter(Context context, List<Book> books, BooksListener listener) {
        this.context = context;
        this.books = books;
        this.booksListener = listener;

    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getCount() {
        return books != null ? books.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.list_item, null);
        TextView titre = view.findViewById(R.id.lblTitle);
        TextView auteur = view.findViewById(R.id.lbl_auteur);
        TextView date = view.findViewById(R.id.lblDate);
        TextView price = view.findViewById(R.id.price);
        titre.setText(books.get(position).getTitre());
        date.setText(books.get(position).getDateEdition());
        auteur.setText(books.get(position).getAuteur());
        price.setText(String.valueOf(books.get(position).getPrice()));
        view.setOnClickListener(view1 -> {
            Timber.d("click position %s",books.get(position));
            booksListener.openModifyDialog(books.get(position));
        });
        return view;
    }
}
