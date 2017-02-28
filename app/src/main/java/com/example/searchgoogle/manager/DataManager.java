package com.example.searchgoogle.manager;


import com.example.searchgoogle.model.DataModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class DataManager {
    private Realm realm;

    public DataManager() {
        realm = Realm.getDefaultInstance();
    }

    public void insertDb(DataModel dataModel) {
        realm.executeTransaction(realm1 -> realm.copyToRealm(dataModel));
    }

    public List<DataModel> getDataAll() {
        return realm.where(DataModel.class).findAll();
    }

    public void removeData(DataModel dataModel) {
        long id = dataModel.getId();
        realm.executeTransaction(realm1 -> {
            RealmResults<DataModel> results = realm.where(DataModel.class).equalTo("id", id).findAll();
            results.deleteAllFromRealm();
        });
    }

    public void removeDataById(long id) {
        realm.executeTransaction(realm1 -> {
            RealmResults<DataModel> results = realm.where(DataModel.class).equalTo("id", id).findAll();
            results.deleteAllFromRealm();
        });
    }

}
