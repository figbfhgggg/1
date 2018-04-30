package com.example.alexander.kurs_4_1.common;

/**
 * Created by Alexander on 27.12.2016.
 */

public interface CallbackApi<T> {
    void onComplete(T t);
    void onError(String error);
}
