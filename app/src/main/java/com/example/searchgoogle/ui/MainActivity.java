package com.example.searchgoogle.ui;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.searchgoogle.App;
import com.example.searchgoogle.R;
import com.example.searchgoogle.adapter.ViewPagerAdapter;
import com.example.searchgoogle.api.ImageService;
import com.example.searchgoogle.constant.ApiConstant;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
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
