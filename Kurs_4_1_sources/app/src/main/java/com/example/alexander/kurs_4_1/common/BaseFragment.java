package com.example.alexander.kurs_4_1.common;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.ButterKnife;

/**
 * Created by Alexander on 16.11.2016.
 */

public abstract class BaseFragment extends Fragment {

    private static final AtomicInteger lasFragmentId = new AtomicInteger(0);
    private final int fragmentId;

    public BaseFragment() {
        fragmentId = lasFragmentId.incrementAndGet();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return null;
        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        View view = inflater.inflate(layout.id(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inject();
        //noinspection unchecked

        getPresenter().setView(this);
        getPresenter().onCreate();
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onDestroyView() {
        //ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    @NonNull
    public abstract BasePresenter getPresenter();

    protected abstract void inject();
}
