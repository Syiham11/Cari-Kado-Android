package com.example.carikado.main.review.datasource.remote;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.carikado.R;
import com.example.carikado.base.model.MyResponse;
import com.example.carikado.rest.ApiClient;
import com.example.carikado.main.review.datasource.ReviewDataSource;
import com.example.carikado.main.review.model.Review;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Merupakan class yang melakukan akses data ke server
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 13 Oktober 2017
 */
public class ReviewRemoteDataSource implements ReviewDataSource {

    private static ReviewRemoteDataSource sInstance = null;

    private Context mContext;

    private ReviewRemoteDataSource(Context context) {
        mContext = context;
    }

    public static ReviewRemoteDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new ReviewRemoteDataSource(context);

        return sInstance;
    }

    @Override
    public void addReview(@NonNull Review review, @NonNull AddReviewCallback addReviewCallback) {
        Call<MyResponse<Integer>> addReview = ApiClient.getApiInterface(mContext).addReview(review);
        addReview.enqueue(new AddReviewResponseCallback(addReviewCallback));
    }

    private class AddReviewResponseCallback implements Callback<MyResponse<Integer>> {

        private AddReviewCallback mAddReviewCallback;

        private AddReviewResponseCallback(AddReviewCallback addReviewCallback) {
            mAddReviewCallback = addReviewCallback;
        }

        @Override
        public void onResponse(@NonNull Call<MyResponse<Integer>> call, @NonNull Response<MyResponse<Integer>> response) {
            MyResponse<Integer> myResponse = response.body();

            if (myResponse != null) {
                Boolean isFinish = myResponse.getData() == 1;
                String message = isFinish ? mContext.getString(R.string.review_complete) :
                        mContext.getString(R.string.review_error);

                myResponse.setMessage(message);
                mAddReviewCallback.onAddSuccess(myResponse);
            } else {
                String message = mContext.getString(R.string.review_error);
                mAddReviewCallback.onAddFailed(message);
            }
        }

        @Override
        public void onFailure(@NonNull Call<MyResponse<Integer>> call, @NonNull Throwable t) {
            String message = mContext.getString(R.string.review_error);
            mAddReviewCallback.onAddFailed(message);
        }
    }
}
