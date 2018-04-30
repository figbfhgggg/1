package com.example.alexander.kurs_4_1.main.common;

import com.example.alexander.kurs_4_1.common.BasePresenter;
import com.example.alexander.kurs_4_1.common.MainRouter;

/**
 * Created by Alexander on 16.11.2016.
 */

public abstract class BaseMainPresenter<View extends BaseMainView> extends BasePresenter<View, MainRouter> {
    @Override
    public void onCreate() {
        getView().onCreate();
    }
}
