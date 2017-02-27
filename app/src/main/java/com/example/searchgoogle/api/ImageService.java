package com.example.searchgoogle.api;

import com.example.searchgoogle.api.response.ImageResponse;
import com.example.searchgoogle.constant.ApiConstant;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ImageService {

    @GET(ApiConstant.GET_IMAGE)
    Observable<ImageResponse> getImages(@Query("key") String key, @Query("cx") String cx,
                                        @Query("q") String content, @Query("start") int start);


}
