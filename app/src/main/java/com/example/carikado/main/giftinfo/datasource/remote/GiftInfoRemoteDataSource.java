package com.example.carikado.main.giftinfo.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyPage;
import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.giftinfo.datasource.GiftInfoDataSource;
import com.example.carikado.main.giftinfo.model.GiftInfo;
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
    public void loadGiftInfos(@NonNull Integer page,
                              @NonNull Integer pageSize,
                              @NonNull Integer sort,
                              @NonNull LoadGiftInfosCallback loadGiftInfosCallback) {
        Call<MyResponse<MyPage<List<GiftInfo>>>> loadGiftInfos = ApiClient.getApiInterface(mContext).findGiftInfos(page, pageSize, sort);
        loadGiftInfos.enqueue(new LoadGiftInfoResponseCallback(loadGiftInfosCallback));
    }

    private class LoadGiftInfoResponseCallback implements Callback<MyResponse<MyPage<List<GiftInfo>>>> {

        private LoadGiftInfosCallback mLoadGiftInfosCallback;

        private LoadGiftInfoResponseCallback(LoadGiftInfosCallback loadGiftInfosCallback) {
            mLoadGiftInfosCallback = loadGiftInfosCallback;
        }

        @Override
        public void onResponse(@NonNull Call<MyResponse<MyPage<List<GiftInfo>>>> call,
                               @NonNull Response<MyResponse<MyPage<List<GiftInfo>>>> response) {
            MyResponse<MyPage<List<GiftInfo>>> myResponse = response.body();

            if (myResponse != null) {
                MyPage<List<GiftInfo>> giftInfoPages = myResponse.getData();
                mLoadGiftInfosCallback.onLoadSuccess(giftInfoPages);
            } else {
                String message = mContext.getString(R.string.gift_info_error);
                mLoadGiftInfosCallback.onLoadFailed(message);
            }
        }

        @Override
        public void onFailure(@NonNull Call<MyResponse<MyPage<List<GiftInfo>>>> call,
                              @NonNull Throwable t) {
            mLoadGiftInfosCallback.onLoadFailed(t.getMessage());
        }
    }
}
