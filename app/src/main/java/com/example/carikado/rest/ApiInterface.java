package com.example.carikado.rest;

import com.example.carikado.base.model.MyPage;
import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.giftinfo.model.GiftInfo;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;
import com.example.carikado.resultgift.model.Gift;
import com.example.carikado.main.review.model.Review;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    @GET("gift-info-category/all")
    Call<MyResponse<List<GiftInfoCategory>>> findAllGiftInfoCategories();

    @GET("gift-info")
    Call<MyResponse<MyPage<List<GiftInfo>>>> findGiftInfos(@Query("page") Integer page,
                                                           @Query("pageSize") Integer pageSize,
                                                           @Query("sort") Integer sort);

    @GET("gift-info/{giftInfoId}")
    Call<MyResponse<GiftInfo>> findGiftInfo(@Path("giftInfoId") Integer giftInfoId);

    @GET("gift/suggestion")
    Call<MyResponse<MyPage<List<Gift>>>> findGifts(@Query("page") Integer page,
                                                   @Query("pageSize") Integer pageSize,
                                                   @Query("sort") Integer sort,
                                                   @Query("gender") String gender,
                                                   @Query("age") Integer age,
                                                   @Query("budgetFrom") Integer budgetFrom,
                                                   @Query("budgetTo") Integer budgetTo,
                                                   @Query("category") String category,
                                                   @Query("name") String name);
}
