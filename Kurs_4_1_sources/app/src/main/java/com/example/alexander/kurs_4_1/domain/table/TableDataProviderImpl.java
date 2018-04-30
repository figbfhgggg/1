package com.example.alexander.kurs_4_1.domain.table;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.common.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexander on 18.01.2017.
 */

public class TableDataProviderImpl implements TableDataProvider {
    @Override
    public void getTable(final CallbackApi<UserBean> callbackApi, String level, String program, String form, String type) {
        Call<UserBean> call = NetworkManager.getInstance().getAbiturients(level, program, form, type);
        call.enqueue(new Callback<UserBean>() {
            @Override
            public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                callbackApi.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<UserBean> call, Throwable t) {
                callbackApi.onError(t.getMessage());
            }
        });
    }
}
