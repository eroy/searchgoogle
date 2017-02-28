package com.example.searchgoogle.ui.search;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.searchgoogle.constant.ApiConstant;

import rx.Observable;

public class SearchPresenter implements SearchContract.Presenter {
    private SearchContract.View view;
    private SearchContract.Model model;
    private String querySearch;
    private int page;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        model = new SearchModel();

    }


    @Override
    public void getImage(String query, int start) {
        if (view.isOnline()) {
            model.getImage(query, start)
                    .retry(3)
                    .flatMap(imageResponse -> Observable.just(imageResponse.getImageModel()))
                    .subscribe(imageModels -> {

                        view.addModel(imageModels);
                    }, throwable -> {
                        Log.e("TTTTT-error", throwable.getMessage());
                    });
            page += 10;
        }
    }


    @Override
    public void setOnScrollListener(RecyclerView recyclerView, LinearLayoutManager layoutManager) {
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                int totalItemCount = layoutManager.getItemCount();
                int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                if (totalItemCount > 1) {
                    if (lastVisibleItem >= totalItemCount - 1) {
                        Log.e("SCROLLL", "This is scroll  " + page);
                        getImage(querySearch, page);
                    }
                }
            }


        });
    }

    @Override
    public void setOnQueryTextListener(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                querySearch = query;
                getImage(querySearch, ApiConstant.START + page);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }
}
