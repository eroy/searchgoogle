package com.example.searchgoogle.ui.favourite;


import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.searchgoogle.model.DataModel;

import java.util.List;

public class FavouritePresenter implements FavouriteContract.Presenter {
    private FavouriteContract.View view;
    private FavouriteContract.Model model;

    public FavouritePresenter(FavouriteContract.View view) {
        this.view = view;
        model =new FavouriteModel();
    }

    @Override
    public void rlSetOnClick(RelativeLayout relativeLayout,long id) {
        relativeLayout.setOnLongClickListener(v -> {
            model.removeData(id);
            view.notifyData();
            return false;
        });
    }

    @Override
    public void ivSetOnClick(ImageView imageView,String url) {
        imageView.setOnClickListener(v -> view.gotToFullScreenImage(url));
    }

    @Override
    public List<DataModel> getAllData() {
        return model.getAllData();

    }
}
