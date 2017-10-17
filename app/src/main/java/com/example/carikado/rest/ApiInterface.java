package com.example.carikado.rest;

import com.example.carikado.base.model.MyResponse;
import com.example.carikado.review.model.Review;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Class yang dibuat untuk mengatur routing rest service aplikasi
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 29 September 2017
 */
public interface ApiInterface {

    @POST("review/add")
    Call<MyResponse<Integer>> addReview(@Body Review review);

    @POST("giftinfo/{page}/{pageSize}")
    Call<MyResponse> findGiftInfos(@Path("page") String page, @Path("pageSize") String pageSize);

    @POST("giftinfo/{giftInfoId}")
    Call<MyResponse> findGiftInfo(@Path("giftInfoId") String giftInfoId);
}
