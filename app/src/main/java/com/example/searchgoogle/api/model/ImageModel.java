package com.example.searchgoogle.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageModel {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("pagemap")
    @Expose
    private Pagemap pagemap;

    public String getTitle() {
        return title;
    }

    public Pagemap getPagemap() {
        return pagemap;
    }
}
