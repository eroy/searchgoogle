package com.example.searchgoogle.ui.search;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.ImageView;

import com.example.searchgoogle.api.model.ImageModel;
import com.example.searchgoogle.api.response.ImageResponse;

import java.util.List;

import rx.Observable;



public interface SearchContract {
    interface Model {
        Observable<ImageResponse> getImage(String query,int start);

    }

    interface View {

        boolean isOnline();
        void addModel(List<ImageModel> list);
        void clearList();
        void gotToFullScreenImage(String url);
    }

    interface Presenter {
        void getImage(String query,int start);
        void setOnQueryTextListener(SearchView searchView);
        void setOnScrollListener(RecyclerView recyclerView,LinearLayoutManager layoutManager);

        void setOnClickListenerImage(ImageView image,String url);
    }


}
