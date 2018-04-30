package com.example.alexander.kurs_4_1.domain.form;

import com.example.alexander.kurs_4_1.common.CallbackApi;

/**
 * Created by Alexander on 17.11.2016.
 */
public interface SelectionDataProvider {
    void getAllSelection(CallbackApi<SelectionBean> callbackApi);
}
