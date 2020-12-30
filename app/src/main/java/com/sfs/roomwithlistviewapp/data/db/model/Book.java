package com.sfs.roomwithlistviewapp.data.db.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "livre")
public class Book {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String titre;
    private String auteur;
    private String dateEdition;
    private long price;
    private String image;

    public Book() {
    }

    public Book(String titre, String auteur, String dateEdition, long price) {
        this.titre = titre;
        this.auteur = auteur;
        this.dateEdition = dateEdition;
        this.price = price;
        this.image = "image";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
