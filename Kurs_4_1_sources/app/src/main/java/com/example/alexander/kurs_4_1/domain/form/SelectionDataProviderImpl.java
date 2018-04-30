package com.example.alexander.kurs_4_1.domain.form;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.common.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexander on 30.11.2016.
 */

public class SelectionDataProviderImpl implements SelectionDataProvider {

    @Override
    public void getAllSelection(final CallbackApi<SelectionBean> callbackApi) {
        Call<SelectionBean> call = NetworkManager.getInstance().getPlans();
        call.enqueue(new Callback<SelectionBean>() {
            @Override
            public void onResponse(Call<SelectionBean> call, Response<SelectionBean> response) {
                callbackApi.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<SelectionBean> call, Throwable t) {
                callbackApi.onError(t.getMessage());
            }
        });
    }
}
