package com.example.carikado.review.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.carikado.R;
import com.example.carikado.review.presenter.ReviewPresenter;
import com.example.carikado.review.view.fragment.ReviewFragment;
import com.example.carikado.util.ActivityUtils;
import com.example.carikado.util.Injection;

/**
 * Class yang mengatur tampilan review
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 27 September 2017
 */

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_activity);

        ReviewFragment reviewFragment = ReviewFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), reviewFragment,
                R.id.fl_review);

        new ReviewPresenter(Injection.proviceReviewRepository(this), reviewFragment); // TODO tambahkan repository
    }
}
