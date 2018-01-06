package com.example.carikado.main.view;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.carikado.R;
import com.example.carikado.main.findgift.presenter.FindGiftPresenter;
import com.example.carikado.main.findgift.view.FindGiftFragment;
import com.example.carikado.main.giftinfo.presenter.GiftInfoPresenter;
import com.example.carikado.main.giftinfo.view.GiftInfoFragment;
import com.example.carikado.main.help.presenter.HelpPresenter;
import com.example.carikado.main.help.view.HelpFragment;
import com.example.carikado.util.ActivityUtils;
import com.example.carikado.util.Injection;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Merupakan tampilan home aplikasi setelah splash screen tampil
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */
public class MainActivity extends AppCompatActivity {

    private final String mFindGiftTag = "Find Gift Fragment";
    private final String mGiftInfoTag = "Gift Info Fragment";
    private final String mHelpTag = "Help Fragment";

    private final String mTag = "Tag";
    private final String mFragmentTag = "Fragment";
    private final String mPresenterTag = "Presenter";
    private final String mActiveTag = "Active Icon";
    private final String mInactiveTag = "Inactive Icon";

    @BindView(R.id.bnv_main)
    public BottomNavigationView mBnvMain;

    private HashMap<Integer, HashMap<String, Object>> mMenuMap = new HashMap<>();
    private FragmentManager mFragmentManager;
    private Menu mOpMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        mBnvMain.setOnNavigationItemSelectedListener(new BNVMainOnSelectedListener());
        mOpMenu = mBnvMain.getMenu();
        mFragmentManager = getSupportFragmentManager();

        setBottomNavigationMenu();
        ActivityUtils.addFragmentToActivity(
                mFragmentManager,
                (Fragment) mMenuMap.get(R.id.menu_find_gift).get(mFragmentTag),
                R.id.fl_main,
                mFindGiftTag);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = mFragmentManager.findFragmentByTag(mFindGiftTag);

        if (fragment != null && fragment.isVisible())
            showExitConfirmation();
        else
            mBnvMain.setSelectedItemId(R.id.menu_find_gift);
    }

    private void setBottomNavigationMenu() {
        setFindGiftMenu();
        setGiftInfoMenu();
        setHelpMenu();
    }

    private void setFindGiftMenu() {
        HashMap<String, Object> objectHashMap = new HashMap<>();
        FindGiftFragment findGiftFragment = FindGiftFragment.newInstance();

        objectHashMap.put(mTag, mFindGiftTag);
        objectHashMap.put(mFragmentTag, findGiftFragment);
        objectHashMap.put(mPresenterTag, new FindGiftPresenter(Injection.provideGiftInfoCategoryRepository(this),
                Injection.provideGenderRepository(this),
                findGiftFragment));
        objectHashMap.put(mActiveTag, ContextCompat.getDrawable(this, R.drawable.ic_find_gift_active));
        objectHashMap.put(mInactiveTag, ContextCompat.getDrawable(this, R.drawable.ic_find_gift_inactive));

        mMenuMap.put(R.id.menu_find_gift, objectHashMap);
    }

    private void setGiftInfoMenu() {
        HashMap<String, Object> objectHashMap = new HashMap<>();
        GiftInfoFragment giftInfoFragment = GiftInfoFragment.newInstance();

        objectHashMap.put(mTag, mGiftInfoTag);
        objectHashMap.put(mFragmentTag, giftInfoFragment);
        objectHashMap.put(mPresenterTag, new GiftInfoPresenter(Injection.provideGiftInfoRepository(this), giftInfoFragment));
        objectHashMap.put(mActiveTag, ContextCompat.getDrawable(this, R.drawable.ic_gift_info_active));
        objectHashMap.put(mInactiveTag, ContextCompat.getDrawable(this, R.drawable.ic_gift_info_inactive));

        mMenuMap.put(R.id.menu_gift_info, objectHashMap);
    }

    private void setHelpMenu() {
        HashMap<String, Object> objectHashMap = new HashMap<>();
        HelpFragment helpFragment = HelpFragment.newInstance();

        // TODO buat repository

        objectHashMap.put(mTag, mHelpTag);
        objectHashMap.put(mFragmentTag, helpFragment);
        objectHashMap.put(mPresenterTag, new HelpPresenter(helpFragment)); // TODO masukkan repository
        objectHashMap.put(mActiveTag, ContextCompat.getDrawable(this, R.drawable.ic_help_active));
        objectHashMap.put(mInactiveTag, ContextCompat.getDrawable(this, R.drawable.ic_help_inactive));

        mMenuMap.put(R.id.menu_help, objectHashMap);
    }

    private void showExitConfirmation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String title = getString(R.string.exit);
        String message = getString(R.string.exit_confirm);
        String yes = getString(R.string.yes);
        String no = getString(R.string.no);

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(no, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        AlertDialog dialog = builder.create();

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    private class BNVMainOnSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            boolean isNull;
            int id = item.getItemId();
            item.setEnabled(true);
            item.setChecked(true);

            setBottomNavigationMenu();

            HashMap<String, Object> menu;

            for (Map.Entry<Integer, HashMap<String, Object>> entry : mMenuMap.entrySet()) {
                int mapId = entry.getKey();
                MenuItem opMenuItem = mOpMenu.findItem(mapId);

                if (id != mapId)
                    opMenuItem.setIcon((Drawable) entry.getValue().get(mInactiveTag));
                else
                    opMenuItem.setIcon((Drawable) entry.getValue().get(mActiveTag));
            }

            menu = mMenuMap.get(id);
            isNull = menu == null;

            if (!isNull)
                ActivityUtils.replaceFragmentOnActivity(
                        mFragmentManager,
                        (Fragment) menu.get(mFragmentTag),
                        R.id.fl_main,
                        (String) menu.get(mTag));

            return isNull;
        }
    }
}
