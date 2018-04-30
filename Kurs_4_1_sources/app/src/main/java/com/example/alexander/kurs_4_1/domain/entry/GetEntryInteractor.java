package com.example.alexander.kurs_4_1.domain.entry;

import com.example.alexander.kurs_4_1.common.CallbackApi;

import javax.inject.Inject;

/**
 * Created by Alexander on 17.11.2016.
 */
public class GetEntryInteractor {
    private final EntryDataProvider selectionDataProvider;

    @Inject
    protected GetEntryInteractor(EntryDataProvider selectionDataProvider) {
        this.selectionDataProvider = selectionDataProvider;
    }

    public void getConsultations(String dayAt, CallbackApi<Entry> callbackApi){
        selectionDataProvider.getConsultations(dayAt, callbackApi);
    }

    public void getDays(CallbackApi<Dates> callbackApi){
        selectionDataProvider.getDays(callbackApi);
    }

    public void sendEntry(String name, String level, String program, String form, String type, String day_at, String time_at, String user_ip, String create_at, final CallbackApi<Result> callbackApi){
        selectionDataProvider.sendEntry(name, level, program, form, type, day_at, time_at, user_ip, create_at, callbackApi);
    }
}
