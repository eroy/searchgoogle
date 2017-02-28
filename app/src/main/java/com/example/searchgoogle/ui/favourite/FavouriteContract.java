package com.example.searchgoogle.ui.favourite;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.searchgoogle.model.DataModel;

import java.util.List;



public interface FavouriteContract {

    interface Model {
        void removeData(long id);
        List<DataModel> getAllData();
    }

    interface View {
        void gotToFullScreenImage(String url);
        void notifyData();
    }

    interface Presenter {

        void rlSetOnClick(RelativeLayout relativeLayout,long id);
        void ivSetOnClick(ImageView imageView,String url);
        List<DataModel> getAllData();
    }
}
