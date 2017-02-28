package com.example.searchgoogle.ui.favourite;

import com.example.searchgoogle.App;
import com.example.searchgoogle.manager.DataManager;
import com.example.searchgoogle.model.DataModel;

import java.util.List;


public class FavouriteModel implements FavouriteContract.Model {
    DataManager dataManager;

    public FavouriteModel() {
        dataManager = App.getsDataManager();
    }

    @Override
    public void removeData(long id) {
        dataManager.removeDataById(id);
    }

    @Override
    public List<DataModel> getAllData() {
        return dataManager.getDataAll();
    }
}
