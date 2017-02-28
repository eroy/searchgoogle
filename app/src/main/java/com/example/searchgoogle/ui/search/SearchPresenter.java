package com.example.searchgoogle.ui.search;


import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.searchgoogle.api.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View view;
    private SearchContract.Model model;
    private List<ImageModel> models = new ArrayList<>();

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        model = new SearchModel();

    }



    private void getImage(String query) {
        model.getImage(query, 1)
                .flatMap(imageResponse -> Observable.just(imageResponse.getImageModel()))
                .subscribe(imageModels -> {

                }, throwable -> {
                    Log.e("TTTTT-error", throwable.getMessage());
                });
//        Log.e("OHOHO", list.get(0).getPagemap().getCseImage().get(0).getSrc());
//        return list;
    }


    @Override
    public void setOnQueryTextListener(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getImage(query);
                Log.e("OHOHO", models.get(0).getTitle());

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }
}
