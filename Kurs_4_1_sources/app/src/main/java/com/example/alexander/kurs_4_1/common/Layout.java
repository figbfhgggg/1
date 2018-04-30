package com.example.alexander.kurs_4_1.common;

/**
 * Created by Alexander on 17.11.2016.
 */

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layout{
    @LayoutRes int id();
}
