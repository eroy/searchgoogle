package com.example.searchgoogle.ui.search;

import com.example.searchgoogle.App;
import com.example.searchgoogle.api.ImageService;
import com.example.searchgoogle.api.response.ImageResponse;
import com.example.searchgoogle.constant.ApiConstant;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SearchModel implements SearchContract.Model {
    ImageService imageService;

    public SearchModel() {
        imageService = App.getApiManager().getImageService();
    }


    @Override
    public Observable<ImageResponse> getImage(String query,int start) {
        return imageService.getImages(ApiConstant.KEY,ApiConstant.CX,query,start)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
