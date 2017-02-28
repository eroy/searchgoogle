package com.example.searchgoogle.ui.search;

import com.example.searchgoogle.App;
import com.example.searchgoogle.api.ImageService;
import com.example.searchgoogle.api.response.ImageResponse;
import com.example.searchgoogle.constant.ApiConstant;
import com.example.searchgoogle.manager.DataManager;
import com.example.searchgoogle.model.DataModel;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SearchModel implements SearchContract.Model {
    private ImageService imageService;
    private DataManager dataManager;

    public SearchModel() {
        dataManager = App.getsDataManager();
        imageService = App.getApiManager().getImageService();
    }


    @Override
    public Observable<ImageResponse> getImage(String query, int start) {
        return imageService.getImages(ApiConstant.KEY, ApiConstant.CX, query, start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void insertData(DataModel dataModel) {
        dataManager.insertDb(dataModel);
    }

    @Override
    public void removeData(DataModel dataModel) {
        dataManager.removeData(dataModel);
    }

    @Override
    public List<DataModel> getAllData() {
        return dataManager.getDataAll();
    }

}
