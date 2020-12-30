package com.sfs.roomwithlistviewapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.sfs.roomwithlistviewapp.BooksListener;
import com.sfs.roomwithlistviewapp.R;
import com.sfs.roomwithlistviewapp.data.db.model.Book;

public class AddDialog {
    public void AddFormDialog(Activity activity, BooksListener listener) {
        final Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_add_book);

        EditText price = (EditText) dialog.findViewById(R.id.price);
        EditText date = (EditText) dialog.findViewById(R.id.date);
        EditText btnTitle = (EditText) dialog.findViewById(R.id.btnTitle);
        EditText auteur = (EditText) dialog.findViewById(R.id.auteur);

        Button save = (Button) dialog.findViewById(R.id.save);
        save.setText("save");

        save.setOnClickListener(v -> {
            listener.addBook(new Book(btnTitle.getText().toString(),
                    auteur.getText().toString(),
                    date.getText().toString(),
                    Integer.valueOf(price.getText().toString())));
            dialog.dismiss();
        });


        dialog.show();
    }

    public void showAndModifyDialog(Activity activity, BooksListener listener, Book book) {
        final Dialog dialog = new Dialog(activity);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_add_book);

        EditText price = (EditText) dialog.findViewById(R.id.price);
        EditText date = (EditText) dialog.findViewById(R.id.date);
        EditText btnTitle = (EditText) dialog.findViewById(R.id.btnTitle);
        EditText auteur = (EditText) dialog.findViewById(R.id.auteur);
        price.setText(String.valueOf(book.getPrice()));
        date.setText(book.getDateEdition());
        btnTitle.setText(book.getTitre());
        auteur.setText(book.getAuteur());

        Button save = (Button) dialog.findViewById(R.id.save);
        save.setText("modify");

        save.setOnClickListener(v -> {
            book.setTitre(btnTitle.getText().toString());
            book.setAuteur(auteur.getText().toString());
            book.setPrice(Integer.valueOf(price.getText().toString()));
            book.setDateEdition(date.getText().toString());
            listener.updateBook(book);
            dialog.dismiss();
        });


        dialog.show();
    }
}
