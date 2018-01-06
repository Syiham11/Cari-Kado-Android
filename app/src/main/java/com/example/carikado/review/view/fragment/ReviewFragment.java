package com.example.carikado.review.view.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.carikado.R;
import com.example.carikado.review.contract.ReviewContract;
import com.example.carikado.review.model.Review;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Merupakan class yang mengatur view dari review
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 11 Oktober 2017
 */
public class ReviewFragment extends Fragment implements ReviewContract.View {

    @BindView(R.id.tb_review)
    public Toolbar mTbReview;

    @BindView(R.id.tiet_name)
    public TextInputEditText mTietName;

    @BindView(R.id.tiet_email)
    public TextInputEditText mTietEmail;

    @BindView(R.id.tiet_comment)
    public TextInputEditText mTietComment;

    @BindView(R.id.til_name)
    public TextInputLayout mTilName;

    @BindView(R.id.til_email)
    public TextInputLayout mTIlEmail;

    @BindView(R.id.til_comment)
    public TextInputLayout mTilComment;

    @BindView(R.id.rb_rating)
    public RatingBar mRbRating;

    @OnClick(R.id.btn_submit)
    public void submit() {
        Review review = new Review();

        String name = mTietName.getText().toString();
        String email = mTietEmail.getText().toString();
        String comment = mTietComment.getText().toString();
        int rating = (int) mRbRating.getRating();

        review.setName(name);
        review.setEmail(email);
        review.setComment(comment);
        review.setRating(rating);

        mReviewPresenter.submitReview(review);
    }

    private ProgressDialog mProgressDialog;
    private ReviewContract.Presenter mReviewPresenter;

    public ReviewFragment() {
        // Default constructor
    }

    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.review_fragment, container, false);
        ButterKnife.bind(this, view);

        mTbReview.setTitle("");
        ((AppCompatActivity) getActivity()).setSupportActionBar(mTbReview);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        mTietName.requestFocus();

        mProgressDialog = new ProgressDialog(getContext());
        mProgressDialog.setMessage(getString(R.string.review_loading));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);

        return view;
    }

    @Override
    public void setPresenter(@NonNull ReviewContract.Presenter presenter) {
        mReviewPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showNameEmpty() {
        mTilName.setErrorEnabled(true);
        mTilName.setError(getString(R.string.name_empty));
    }

    @Override
    public void hideNameEmpty() {
        mTilName.setErrorEnabled(false);
    }

    @Override
    public void showEmailEmpty() {
        mTIlEmail.setErrorEnabled(true);
        mTIlEmail.setError(getString(R.string.email_empty));
    }

    @Override
    public void hideEmailEmpty() {
        mTIlEmail.setErrorEnabled(false);
    }

    @Override
    public void showCommentEmpty() {
        mTilComment.setErrorEnabled(true);
        mTilComment.setError(getString(R.string.comment_empty));
    }

    @Override
    public void hideCommentEmpty() {
        mTilComment.setErrorEnabled(false);
    }

    @Override
    public void showStarsEmpty() {
        Toast.makeText(getContext(), getString(R.string.rate_empty), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showSubmitAlert(@NonNull String message, @NonNull Boolean isFinish) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        String title = getString(R.string.review);
        String ok = getString(R.string.ok);

        builder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(ok, new AlertOkClickListener(isFinish));

        AlertDialog dialog = builder.create();

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private class AlertOkClickListener implements DialogInterface.OnClickListener {

        private boolean mIsFinish;

        private AlertOkClickListener(boolean isFinish) {
            mIsFinish = isFinish;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();

            if (mIsFinish)
                getActivity().finish();
        }
    }
}
