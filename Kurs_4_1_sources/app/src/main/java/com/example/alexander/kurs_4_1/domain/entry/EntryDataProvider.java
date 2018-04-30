package com.example.alexander.kurs_4_1.domain.entry;

import com.example.alexander.kurs_4_1.common.CallbackApi;

/**
 * Created by Alexander on 17.11.2016.
 */
public interface EntryDataProvider {
    void getConsultations(String dayAt, CallbackApi<Entry> callbackApi);
    void getDays(CallbackApi<Dates> callbackApi);
    void sendEntry(String name, String level, String program, String form, String type, String day_at, String time_at, String user_ip, String create_at, CallbackApi<Result> callbackApi);
}
