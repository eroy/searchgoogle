package com.example.searchgoogle.api;


import com.example.searchgoogle.constant.ApiConstant;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private Retrofit retrofit;
    private ImageService imageService;

    public ApiManager() {
        initRetrofit();
        initServices();
    }

    public ImageService getImageService() {
        return imageService;
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstant.BASE_URL)
                .addConverterFactory(createGsonConverter())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private void initServices() {
        if (retrofit != null) {
            imageService = retrofit.create(ImageService.class);

        }

    }


    private GsonConverterFactory createGsonConverter() {
        GsonBuilder builder = new GsonBuilder()
                .setLenient()
                .serializeNulls();
        return GsonConverterFactory.create(builder.create());
    }
}
