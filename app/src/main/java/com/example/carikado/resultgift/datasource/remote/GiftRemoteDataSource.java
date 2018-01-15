package com.example.carikado.resultgift.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyPage;
import com.example.carikado.base.model.MyResponse;
import com.example.carikado.main.findgift.model.Search;
import com.example.carikado.rest.ApiClient;
import com.example.carikado.resultgift.datasource.GiftDataSource;
import com.example.carikado.resultgift.model.Gift;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan class yang melakukan akses data ke server
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 27 Desember 2017
 */
public class GiftRemoteDataSource implements GiftDataSource {

    private static GiftRemoteDataSource sInstance = null;

    private Context mContext;

    private GiftRemoteDataSource(Context context) {
        mContext = context;
    }

    public static GiftRemoteDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new GiftRemoteDataSource(context);

        return sInstance;
    }

    @Override
    public void loadGifts(@NonNull Integer page,
                          @NonNull Integer pageSize,
                          @NonNull Integer sort,
                          @NonNull Search search,
                          @NonNull LoadGiftsCallback loadGiftsCallback) {
        Call<MyResponse<MyPage<List<Gift>>>> loadGifts = ApiClient.getApiInterface(mContext)
                .findGifts(page, pageSize, sort, search.getGender(), search.getAge(),
                        search.getBudgetFrom(), search.getBudgetTo(), search.getCategory(),
                        search.getName());
        loadGifts.enqueue(new LoadGiftsResponseCallback(loadGiftsCallback));
    }

    private class LoadGiftsResponseCallback implements Callback<MyResponse<MyPage<List<Gift>>>> {

        private LoadGiftsCallback mLoadGiftsCallback;

        private LoadGiftsResponseCallback(LoadGiftsCallback loadGiftsCallback) {
            mLoadGiftsCallback = loadGiftsCallback;
        }

        @Override
        public void onResponse(@NonNull Call<MyResponse<MyPage<List<Gift>>>> call,
                               @NonNull Response<MyResponse<MyPage<List<Gift>>>> response) {
            MyResponse<MyPage<List<Gift>>> myResponse = response.body();

            if (myResponse != null) {
                MyPage<List<Gift>> giftPages = myResponse.getData();
                mLoadGiftsCallback.onLoadSuccess(giftPages);
            } else {
                String message = mContext.getString(R.string.result_gift_error);
                mLoadGiftsCallback.onLoadFailed(message);
            }
        }

        @Override
        public void onFailure(@NonNull Call<MyResponse<MyPage<List<Gift>>>> call,
                              @NonNull Throwable t) {
            mLoadGiftsCallback.onLoadFailed(t.getMessage());
        }
    }
}
