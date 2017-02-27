package com.example.searchgoogle;

import android.app.Application;

import com.example.searchgoogle.api.ApiManager;

public class App extends Application {
    private static ApiManager sApiManager;


    @Override
    public void onCreate() {
        super.onCreate();


    }

    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }

}
