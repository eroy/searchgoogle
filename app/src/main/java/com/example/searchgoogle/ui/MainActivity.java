package com.example.searchgoogle.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.example.searchgoogle.App;
import com.example.searchgoogle.R;
import com.example.searchgoogle.api.ImageService;
import com.example.searchgoogle.constant.ApiConstant;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    Button btnGetTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGetTest = (Button) findViewById(R.id.btn_get_test);

        btnGetTest.setOnClickListener(v -> {

            getImage("baby");

        });

    }
    private void getImage(String search) {
        ImageService imageService = App.getApiManager().getImageService();

        imageService.getImages(ApiConstant.KEY,ApiConstant.CX,search,11)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(imageResponse -> Observable.just(imageResponse.getImageModel()))
                .subscribe(imageModel -> {

                    Log.e("TTTTT", imageModel.get(0).getTitle());
                }, throwable -> {
                    Log.e("TTTTT-error", throwable.getMessage());
                });


    }

}
