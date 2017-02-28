package com.example.searchgoogle.ui;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.searchgoogle.R;
import com.example.searchgoogle.util.LoadImage;


public class FullScreenImageFragment extends DialogFragment {
    private ImageView imageView;
    private static final String IMAGE_URL="image_url";

    public FullScreenImageFragment() {
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        theme = R.style.AlertDialogFullScreen;
        setStyle(style, theme);
        // Required empty public constructor
    }

    public FullScreenImageFragment newInstance(String url) {
        FullScreenImageFragment fullScreenImageFragment =new FullScreenImageFragment();
        Bundle bundle =new Bundle();
        bundle.putString(IMAGE_URL,url);
        fullScreenImageFragment.setArguments(bundle);
        return fullScreenImageFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_full_screen_image, container, false);


        String imageUrl = getArguments().getString(IMAGE_URL);


        Log.e("FULL_SCREEN", imageUrl);
        imageView = (ImageView) view.findViewById(R.id.full_image_view);
        LoadImage.downloadImageToView(imageUrl,imageView);




        return view;
    }

}
