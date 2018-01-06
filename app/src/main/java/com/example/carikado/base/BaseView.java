package com.example.carikado.base;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Interface root untuk view
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public interface BaseView<T> {

    void setPresenter(@NonNull T presenter);
    Context getContextView();
}
