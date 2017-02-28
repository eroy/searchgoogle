package com.example.searchgoogle.model;

import java.util.Random;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class DataModel extends RealmObject {
    private String title;
    private String urlImage;
    @PrimaryKey
    private long id;


    public DataModel(String title, String urlImage) {
        this.id = System.currentTimeMillis() + new Random().nextInt(1000);
        this.title = title;
        this.urlImage = urlImage;
    }

    public DataModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
