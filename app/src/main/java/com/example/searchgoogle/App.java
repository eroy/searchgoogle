package com.example.searchgoogle;

import android.app.Application;

import com.example.searchgoogle.api.ApiManager;
import com.example.searchgoogle.manager.DataManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {
    private static ApiManager sApiManager;
    private static DataManager sDataManager;


    public static DataManager getsDataManager() {
        return sDataManager;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RealmConfiguration configuration = new RealmConfiguration
                .Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(configuration);
        sDataManager = new DataManager();

    }

    public static ApiManager getApiManager() {
        if (sApiManager == null) {
            sApiManager = new ApiManager();
        }
        return sApiManager;
    }

}
