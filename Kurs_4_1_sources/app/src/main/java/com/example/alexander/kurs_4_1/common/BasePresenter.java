package com.example.alexander.kurs_4_1.common;

/**
 * Created by Alexander on 16.11.2016.
 */

public abstract class BasePresenter<View, Router> {
    private View view;
    private Router router;

    public abstract void onStart();

    public abstract void onStop();

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public abstract void onResume();

    public abstract void onCreate();
}
