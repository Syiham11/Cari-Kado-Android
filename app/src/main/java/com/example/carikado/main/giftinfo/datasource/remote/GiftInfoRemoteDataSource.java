package com.example.carikado.main.giftinfo.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.giftinfo.datasource.GiftInfoDataSource;
import com.example.carikado.rest.ApiClient;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan class yang melakukan akses data ke server
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 18 Oktober 2017
 */
public class GiftInfoRemoteDataSource implements GiftInfoDataSource {

    private static GiftInfoRemoteDataSource sInstance = null;

    private Context mContext;

    private GiftInfoRemoteDataSource(Context context) {
        mContext = context;
    }

    public static GiftInfoRemoteDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new GiftInfoRemoteDataSource(context);

        return sInstance;
    }

    @Override
    public void LoadGiftInfos(@NonNull HashMap<String, String> params, @NonNull LoadGiftInfosCallback loadGiftInfosCallback) {
//        Call<MyResponse<List>> loadGiftInfos = ApiClient.getApiInterface(mContext).findGiftInfos(params);
//        loadGiftInfos.enqueue();
    }

    private class LoadGiftInfoResponseCallback implements Callback<MyResponse<List>> {

        private LoadGiftInfosCallback mLoadGiftInfosCallback;

        private LoadGiftInfoResponseCallback(LoadGiftInfosCallback loadGiftInfosCallback) {
            mLoadGiftInfosCallback = loadGiftInfosCallback;
        }

        @Override
        public void onResponse(Call<MyResponse<List>> call, Response<MyResponse<List>> response) {
            MyResponse<List> myResponse = response.body();
//            my

//            if (myResponse != null) {
//
//            } else {
//
//            }
        }

        @Override
        public void onFailure(Call<MyResponse<List>> call, Throwable t) {
            mLoadGiftInfosCallback.onLoadFailed(t.getMessage());
        }
    }
}
