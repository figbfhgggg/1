package com.example.alexander.kurs_4_1.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

/**
 * Created by Alexander on 29.11.2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return;
        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        setContentView(layout.id());
        ButterKnife.bind(this);
        NetworkManager.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ButterKnife.unbind(this);
    }
}
