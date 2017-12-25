package com.example.carikado.main.findgift.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.findgift.datasource.GiftInfoCategoryDataSource;
import com.example.carikado.main.giftinfo.model.GiftInfoCategory;
import com.example.carikado.rest.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan class yang melakukan akses data ke server
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 20 Desember 2017
 */
public class GiftInfoCategoryRemoteDataSource implements GiftInfoCategoryDataSource {

    private static GiftInfoCategoryRemoteDataSource sInstance = null;

    private Context mContext;

    private GiftInfoCategoryRemoteDataSource(Context context) {
        mContext = context;
    }

    public static GiftInfoCategoryRemoteDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new GiftInfoCategoryRemoteDataSource(context);

        return sInstance;
    }

    @Override
    public void loadGiftInfoCategories(@NonNull LoadGiftInfoCategoriessCallback loadGiftInfoCategoriesCallback) {
        Call<MyResponse<List<GiftInfoCategory>>> loadGiftInfoCategories = ApiClient.getApiInterface(mContext).findAllGiftInfoCategories();
        loadGiftInfoCategories.enqueue(new LoadGiftInfoCategoriesResponseCallback(loadGiftInfoCategoriesCallback));
    }

    private class LoadGiftInfoCategoriesResponseCallback implements Callback<MyResponse<List<GiftInfoCategory>>> {

        private LoadGiftInfoCategoriessCallback mLoadGiftInfoCategoriessCallback;

        private LoadGiftInfoCategoriesResponseCallback(LoadGiftInfoCategoriessCallback loadGiftInfoCategoriessCallback) {
            mLoadGiftInfoCategoriessCallback = loadGiftInfoCategoriessCallback;
        }

        @Override
        public void onResponse(Call<MyResponse<List<GiftInfoCategory>>> call, Response<MyResponse<List<GiftInfoCategory>>> response) {
            MyResponse<List<GiftInfoCategory>> myResponse = response.body();

            if (myResponse != null) {
                List<GiftInfoCategory> giftInfoCategories = myResponse.getData();
                mLoadGiftInfoCategoriessCallback.onLoadSuccess(giftInfoCategories);
            } else {
                String message = mContext.getString(R.string.gift_info_category_error);
                mLoadGiftInfoCategoriessCallback.onLoadFailed(message);
            }
        }

        @Override
        public void onFailure(Call<MyResponse<List<GiftInfoCategory>>> call, Throwable t) {
            mLoadGiftInfoCategoriessCallback.onLoadFailed(t.getMessage());
        }
    }
}
