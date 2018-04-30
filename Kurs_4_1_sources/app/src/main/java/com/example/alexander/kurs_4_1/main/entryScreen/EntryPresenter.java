package com.example.alexander.kurs_4_1.main.entryScreen;

import com.example.alexander.kurs_4_1.common.CallbackApi;
import com.example.alexander.kurs_4_1.domain.entry.Dates;
import com.example.alexander.kurs_4_1.domain.entry.Entry;
import com.example.alexander.kurs_4_1.domain.entry.GetEntryInteractor;
import com.example.alexander.kurs_4_1.domain.entry.Result;
import com.example.alexander.kurs_4_1.main.common.BaseMainPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by Alexander on 17.11.2016.
 */
public class EntryPresenter extends BaseMainPresenter {

    private final GetEntryInteractor getEntryInteractor;
    private String dayAt;

    @Inject
    public EntryPresenter(GetEntryInteractor getEntryInteractor) {
        this.getEntryInteractor = getEntryInteractor;
    }

    public void onDateClick() {
        getEntryInteractor.getDays(new CallbackApi<Dates>() {
            @Override
            public void onComplete(Dates dates) {
                if (dates.getResult().size() < 1) {
                    ((EntryScreenView) getView()).showError("Извините нет ни одного дня для записи.");
                } else {
                    ((EntryScreenView) getView()).showDatePicker(dates);
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onResume() {

    }

    public void sendEntryClick(String name, String level, String program, String form, String type, String day_at, String time_at) {
        if(check(name) || check(level) || check(program) || check(form) || check(type) || check(day_at) || check(time_at)){
            ((EntryScreenView) getView()).showError("Заполните все поля!");
            return;
        }

        String user_ip = "12.0.0.0";

        final Calendar calendar = Calendar.getInstance();
        Locale locale = new Locale("ru", "RU");
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);

        String create_at = dateFormat.format(calendar.getTime());

        getEntryInteractor.sendEntry(name, level, program, form, type, day_at, time_at, user_ip, create_at, new CallbackApi<Result>() {
            @Override
            public void onComplete(Result result) {
                if(result.getSuccess()){
                    ((EntryScreenView) getView()).showSuccess("Вы успешно записались на прием.");
                } else {
                    ((EntryScreenView) getView()).showError(result.getError());
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    private boolean check(String value){
        return value == null || value.isEmpty();
    }

    public void onTimeButtonClick() {
        if(dayAt == null || dayAt.isEmpty()){
            ((EntryScreenView) getView()).showError("Выберите день для записи.");
            return;
        }

        getEntryInteractor.getConsultations(dayAt, new CallbackApi<Entry>() {
            @Override
            public void onComplete(Entry entry) {
                if(entry.getResult().size() < 1){
                    ((EntryScreenView) getView()).showError("В указанный день нет свободного времени для записи.");
                } else {
                    ((EntryScreenView) getView()).showTimePicker(entry);
                }
            }

            @Override
            public void onError(String error) {

            }
        });
    }

    public void setDayAt(int day){
        dayAt = String.valueOf(day);
    }
}
