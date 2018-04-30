package com.example.alexander.kurs_4_1.domain.table;

import com.example.alexander.kurs_4_1.common.CallbackApi;

import javax.inject.Inject;

/**
 * Created by Alexander on 17.11.2016.
 */
public class GetTableInteractor {
    private final TableDataProvider tableDataProvider;

    @Inject
    protected GetTableInteractor(TableDataProvider tableDataProvider) {
        this.tableDataProvider = tableDataProvider;
    }

    public void getTable(CallbackApi<UserBean> callbackApi, String level, String program, String form, String type){
        tableDataProvider.getTable(callbackApi, level, program, form, type);
    }
}
