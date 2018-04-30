package com.example.alexander.kurs_4_1.domain.entry;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.common.NetworkManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alexander on 30.11.2016.
 */

public class EntryDataProviderImpl implements EntryDataProvider {

    @Override
    public void getConsultations(String dayAt, final CallbackApi<Entry> callbackApi) {
        Call<Entry> call = NetworkManager.getInstance().getConsultations(dayAt);
        call.enqueue(new Callback<Entry>() {
            @Override
            public void onResponse(Call<Entry> call, Response<Entry> response) {
                callbackApi.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<Entry> call, Throwable t) {

            }
        });
    }

    @Override
    public void getDays(final CallbackApi<Dates> callbackApi) {
        Call<Dates> call = NetworkManager.getInstance().getDates();
        call.enqueue(new Callback<Dates>() {
            @Override
            public void onResponse(Call<Dates> call, Response<Dates> response) {
                callbackApi.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<Dates> call, Throwable t) {

            }
        });
    }

    @Override
    public void sendEntry(String name, String level, String program, String form, String type, String day_at, String time_at, String user_ip, String create_at, final CallbackApi<Result> callbackApi) {
        Call<Result> call = NetworkManager.getInstance().sendEntry(name, level, program, form, type, day_at, time_at, user_ip, create_at);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                callbackApi.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }

}
