package com.example.searchgoogle.ui.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.example.searchgoogle.api.model.ImageModel;
import com.example.searchgoogle.api.response.ImageResponse;

import java.util.List;

import rx.Observable;



public interface SearchContract {
    interface Model {
        Observable<ImageResponse> getImage(String query,int start);

    }

    interface View {
        void setImageModels(List<ImageModel> imageModels);
        List<ImageModel> getImageModels();
        boolean isOnline();
        void addModel(List<ImageModel> list);
    }

    interface Presenter {
        void getImage(String query,int start);
        void setOnQueryTextListener(SearchView searchView);
        void setOnScrollListener(RecyclerView recyclerView,LinearLayoutManager layoutManager);
    }


}
