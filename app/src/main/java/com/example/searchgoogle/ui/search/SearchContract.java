package com.example.searchgoogle.ui.search;

import android.support.v7.widget.SearchView;

import com.example.searchgoogle.api.model.ImageModel;
import com.example.searchgoogle.api.response.ImageResponse;

import java.util.List;

import rx.Observable;

/**
 * Created by serj on 2/28/17.
 */

public interface SearchContract {
    interface Model {
        Observable<ImageResponse> getImage(String query,int start);

    }

    interface View {
        void setImageModels(List<ImageModel> imageModels);
        List<ImageModel> getImageModels();
    }

    interface Presenter {

        void setOnQueryTextListener(SearchView searchView);

    }


}
