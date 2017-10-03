package com.example.carikado.view.activity;

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
import com.example.carikado.view.fragment.FindGiftFragment;
import com.example.carikado.view.fragment.GiftInfoFragment;
import com.example.carikado.view.fragment.HelpFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Merupakan tampilan home aplikasi setelah splash screen tampil
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 25 September 2017
 */

public class MainActivity extends AppCompatActivity {

    private final String FIND_GIFT_TAG = "Find Gift Fragment";
    private final String GIFT_INFO_TAG = "Gift Info Fragment";
    private final String HELP_TAG = "Help Fragment";

    private final String FRAGMENT_TAG = "Fragment";
    private final String TAG = "Tag";
    private final String ACTIVE_TAG = "Active Icon";
    private final String INACTIVE_TAG = "Inactive Icon";

    private BottomNavigationView bnvMain;
    private HashMap<Integer, HashMap<String, Object>> menuMap = new HashMap<>();
    private FragmentManager fragmentManager;
    private Menu opMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMain = (BottomNavigationView) findViewById(R.id.bnv_main);
        bnvMain.setOnNavigationItemSelectedListener(new BNVMainOnSelectedListener());

        opMenu = bnvMain.getMenu();
        fragmentManager = getSupportFragmentManager();

        setMenuData();
        showFragment(new FindGiftFragment(), FIND_GIFT_TAG);
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = fragmentManager.findFragmentByTag(FIND_GIFT_TAG);

        if (fragment == null)
            bnvMain.setSelectedItemId(R.id.menu_find_gift);
        else
            showExitConfirm();
    }

    private void setMenuData() {
        HashMap<String, Object> objectHashMap;

        objectHashMap = new HashMap<>();
        objectHashMap.put(FRAGMENT_TAG, new FindGiftFragment());
        objectHashMap.put(TAG, FIND_GIFT_TAG);
        objectHashMap.put(ACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_find_gift_active));
        objectHashMap.put(INACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_find_gift_inactive));

        menuMap.put(R.id.menu_find_gift, objectHashMap);

        objectHashMap = new HashMap<>();
        objectHashMap.put(FRAGMENT_TAG, new GiftInfoFragment());
        objectHashMap.put(TAG, GIFT_INFO_TAG);
        objectHashMap.put(ACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_gift_info_active));
        objectHashMap.put(INACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_gift_info_inactive));

        menuMap.put(R.id.menu_gift_info, objectHashMap);

        objectHashMap = new HashMap<>();
        objectHashMap.put(FRAGMENT_TAG, new HelpFragment());
        objectHashMap.put(TAG, HELP_TAG);
        objectHashMap.put(ACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_help_active));
        objectHashMap.put(INACTIVE_TAG, ContextCompat.getDrawable(this, R.drawable.ic_help_inactive));

        menuMap.put(R.id.menu_help, objectHashMap);
    }

    private void showFragment(Fragment fragment, String tag) {
        fragmentManager.beginTransaction().replace(R.id.fl_main, fragment, tag).commit();
    }

    private void showExitConfirm() {
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

            HashMap<String, Object> menu;

            for (Map.Entry<Integer, HashMap<String, Object>> entry : menuMap.entrySet()) {
                int mapId = entry.getKey();
                MenuItem opMenuItem = opMenu.findItem(mapId);

                if (id != mapId)
                    opMenuItem.setIcon((Drawable) entry.getValue().get(INACTIVE_TAG));
                else
                    opMenuItem.setIcon((Drawable) entry.getValue().get(ACTIVE_TAG));
            }

            menu = menuMap.get(id);
            isNull = menu == null;

            if (!isNull)
                showFragment((Fragment) menu.get(FRAGMENT_TAG), (String) menu.get(TAG));

            return isNull;
        }
    }
}
