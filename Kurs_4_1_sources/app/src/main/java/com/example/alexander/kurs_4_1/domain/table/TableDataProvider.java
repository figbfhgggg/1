package com.example.alexander.kurs_4_1.domain.table;

import com.example.alexander.kurs_4_1.common.CallbackApi;

/**
 * Created by Alexander on 17.11.2016.
 */
public interface TableDataProvider {
    void getTable(CallbackApi<UserBean> callbackApi, String level, String program, String form, String type);
}
