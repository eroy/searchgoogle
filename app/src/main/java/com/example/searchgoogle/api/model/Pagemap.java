package com.example.searchgoogle.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Pagemap {

    @SerializedName("cse_image")
    @Expose
    private List<CseImage> cseImage = null;


    public List<CseImage> getCseImage() {
        return cseImage;
    }

}
