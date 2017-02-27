package com.example.searchgoogle.ui.favourite;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchgoogle.R;
import com.example.searchgoogle.ui.BaseFragment;

public class FavouriteFragment extends BaseFragment {


    public FavouriteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);
    }

}
