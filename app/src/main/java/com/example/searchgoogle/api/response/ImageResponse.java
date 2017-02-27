package com.example.searchgoogle.api.response;

import com.example.searchgoogle.api.model.ImageModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ImageResponse {

    @SerializedName("items")
    private List<ImageModel> imageModel;

    public List<ImageModel> getImageModel() {
        return imageModel;
    }

}
